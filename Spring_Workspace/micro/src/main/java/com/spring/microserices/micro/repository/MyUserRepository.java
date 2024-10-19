package com.spring.microserices.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.microserices.micro.entity.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, String>{

}
