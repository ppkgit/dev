package com.spring.microserices.micro.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.spring.microserices.micro.entity.Hotel;
import com.spring.microserices.micro.entity.HotelRating;
import com.spring.microserices.micro.entity.MyUser;
import com.spring.microserices.micro.exception.ResourceNotFoundException;
import com.spring.microserices.micro.repository.MyUserRepository;

@Service
public class MyUserServicesImpl<T> implements MyUserServices{

	@Autowired
	private MyUserRepository myUserRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//URI
	private final String ratingURL = "http://localhost:8083/rating/userRatings/";
	private final String hotelURL = "http://localhost:8082/hotel/";
	
	@Override
	public ResponseEntity<List<MyUser>> getUsers() {
		
		List<MyUser> myUsers = myUserRepository.findAll();
		
		if(!myUsers.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(myUsers);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@Override
	public ResponseEntity<MyUser> getUser(@PathVariable String id) {
		
		Optional<MyUser> obj  = myUserRepository.findById(id);
		if(obj.isPresent())
		{
			MyUser user = obj.get(); 
			
			// Get rating
			ResponseEntity<List<HotelRating>> responseEntity = restTemplate.exchange(ratingURL + user.getId(), HttpMethod.GET, null,  new ParameterizedTypeReference<List<HotelRating>>() {});
			List<HotelRating> rating = responseEntity.getBody();
			
			List<HotelRating> ratingList = rating.stream().map( ratings -> {
				
				//api call
				ResponseEntity<Hotel> hotelInfo = restTemplate.getForEntity(hotelURL + ratings.getHotelId(), Hotel.class);
				Hotel hotel =  hotelInfo.getBody();
				
				//set hotelInfo to ratings
				ratings.setHotel(hotel);
				
				//return ratings
				return ratings;
			}).collect(Collectors.toList());
			
			
			user.setRating(rating);
			
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		else
		{
			//ResourceNotFoundException exception = new ResourceNotFoundException("Id is not present");
			throw new ResourceNotFoundException("Id is not present");
		}
	
	}

	@Override
	public ResponseEntity<String> saveUser(@RequestBody MyUser user) {
		
		//Generate unique userid
			String ramdomUserId = UUID.randomUUID().toString();
			user.setId(ramdomUserId);
			myUserRepository.save(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("User is saved");
		
		//return null;
	}

}
