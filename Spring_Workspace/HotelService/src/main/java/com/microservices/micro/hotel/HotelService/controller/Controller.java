package com.microservices.micro.hotel.HotelService.controller;

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

import com.microservices.micro.hotel.HotelService.entity.Hotel;
import com.microservices.micro.hotel.HotelService.service.HotelServices;

@RestController
@RequestMapping("/hotel")
public class Controller {

	@Autowired
	private HotelServices hotelServices;
	
	//create
	@PostMapping("/add")
	public ResponseEntity<String> create(@RequestBody Hotel hotel)
	{
		boolean flag = hotelServices.create(hotel);
		
		if(flag)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body("Added");
		}else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not created!!");
		}
	}
	
	//get single
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getById(@PathVariable String id)
	{
		Hotel hotel = hotelServices.getById(id);
		
		if(hotel != null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(hotel);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	//get all
	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> getAll()
	{
		List<Hotel> hotels = hotelServices.getAll();
		
		if(!hotels.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(hotels);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
