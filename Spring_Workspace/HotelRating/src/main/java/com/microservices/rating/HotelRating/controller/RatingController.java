package com.microservices.rating.HotelRating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.rating.HotelRating.entity.HotelRating;
import com.microservices.rating.HotelRating.services.RatingServices;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingServices ratingServices;
	
	@PostMapping("/add")
	public ResponseEntity<HotelRating> createRating(@RequestBody HotelRating rating)
	{
		HotelRating ratings =  ratingServices.createRating(rating);
		
		if(ratings != null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/allRatings")
	public ResponseEntity<List<HotelRating>> getRatings()
	{
		List<HotelRating> allRatings = ratingServices.getAllRatings();
		
		if(!allRatings.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(allRatings);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/userRatings/{userId}")
	public ResponseEntity<List<HotelRating>> getRatingByUserId(@PathVariable String userId)
	{
		List<HotelRating> userRatings = ratingServices.getRatingByUserId(userId);
		
		if(!userRatings.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(userRatings);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/hotelRatings/{hotelId}")
	public ResponseEntity<List<HotelRating>> getRatingByHotelId(@PathVariable String hotelId)
	{
		List<HotelRating> hotelRatings = ratingServices.getRatingByHotelId(hotelId);
		
		if(!hotelRatings.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(hotelRatings);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}
