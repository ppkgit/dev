package com.microservices.micro.hotel.HotelService.service;

import java.util.List;

import com.microservices.micro.hotel.HotelService.entity.Hotel;

public interface HotelServices {

	//add
	public boolean create(Hotel hotel);
	
	//get all
	public List<Hotel> getAll();
	
	//get single
	public Hotel getById(String id);
}
