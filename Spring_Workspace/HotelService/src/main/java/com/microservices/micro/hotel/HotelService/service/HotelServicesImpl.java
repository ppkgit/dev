package com.microservices.micro.hotel.HotelService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.micro.hotel.HotelService.entity.Hotel;
import com.microservices.micro.hotel.HotelService.exceptioin.ResourceNotFoundException;
import com.microservices.micro.hotel.HotelService.repository.HotelRepository;

@Service
public class HotelServicesImpl implements HotelServices{

	@Autowired
	HotelRepository hotelRepository;
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	
	@Override
	public boolean create(Hotel hotel) {
		
		try {
			String id = UUID.randomUUID().toString();
			hotel.setId(id);
			hotelRepository.save(hotel);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Hotel> getAll() {
	
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getById(String id) {
		
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data is not present for given id"));
	}

}
