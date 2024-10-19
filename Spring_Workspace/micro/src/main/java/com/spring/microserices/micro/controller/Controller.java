package com.spring.microserices.micro.controller;

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

import com.spring.microserices.micro.entity.MyUser;
import com.spring.microserices.micro.services.MyUserServicesImpl;

@RestController
@RequestMapping("/myuser")
public class Controller {

	@Autowired
	MyUserServicesImpl service;
	
	//add user
	@PostMapping("/add")
	public ResponseEntity<String> create(@RequestBody MyUser user)
	{
		return service.saveUser(user); 
	}
	
	//get single user
	@GetMapping("/{id}")
	public ResponseEntity<MyUser> getUser(@PathVariable String id)
	{
		return service.getUser(id);
	}
	
	//get all users
	@GetMapping("/users")
	public ResponseEntity<List<MyUser>> getAllUsers()
	{
		return service.getUsers();
	}
}
