package com.spring.microserices.micro.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spring.microserices.micro.entity.MyUser;

public interface MyUserServices {

	public ResponseEntity<String> saveUser(MyUser user);
	
	public ResponseEntity<List<MyUser>> getUsers();
	
	public ResponseEntity<MyUser> getUser(String id);
	
}
