package com.microservices.rating.HotelRating.services;

import java.util.List;

import com.microservices.rating.HotelRating.entity.HotelRating;

public interface RatingServices {

	//create
	HotelRating createRating(HotelRating rating);
	
	// get all ratings
	List<HotelRating> getAllRatings();
	
	//get all by user id
	List<HotelRating> getRatingByUserId(String userId);
	
	//get all by hotel id
	List<HotelRating> getRatingByHotelId(String hotelId);
}
