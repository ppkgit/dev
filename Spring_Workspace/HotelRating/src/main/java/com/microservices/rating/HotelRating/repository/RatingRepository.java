package com.microservices.rating.HotelRating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.rating.HotelRating.entity.HotelRating;

//public interface RatingRepository extends MongoRepository<HotelRating, String>{
public interface RatingRepository extends JpaRepository<HotelRating, String>{
	
	List<HotelRating> findByUserId(String userId);
	
	List<HotelRating> findByHotelId(String hotelId);

}
