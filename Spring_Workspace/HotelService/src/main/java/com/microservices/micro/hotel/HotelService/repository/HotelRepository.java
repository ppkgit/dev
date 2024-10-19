package com.microservices.micro.hotel.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.micro.hotel.HotelService.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
