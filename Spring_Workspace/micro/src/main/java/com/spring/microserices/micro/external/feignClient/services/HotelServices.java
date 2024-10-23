package com.spring.microserices.micro.external.feignClient.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.microserices.micro.entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelServices {

	@GetMapping("/hotel/{id}")
	ResponseEntity<Hotel> getHotel(@PathVariable String id);
}
