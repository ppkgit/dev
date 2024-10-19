package com.microservices.rating.HotelRating.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.rating.HotelRating.entity.HotelRating;
import com.microservices.rating.HotelRating.repository.RatingRepository;

@Service
public class RatingServicesImpl implements RatingServices{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public HotelRating createRating(HotelRating rating) {
		
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingRepository.save(rating);
	}

	@Override
	public List<HotelRating> getAllRatings() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<HotelRating> getRatingByUserId(String userId) {
	
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<HotelRating> getRatingByHotelId(String hotelId) {
		
		return ratingRepository.findByHotelId(hotelId);
	}

}
