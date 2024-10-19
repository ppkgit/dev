package com.spring.microserices.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MyUserApplication {

	public static void main(String[] args) {
		// Comments added to check git status
		SpringApplication.run(MyUserApplication.class, args);
	}

}
