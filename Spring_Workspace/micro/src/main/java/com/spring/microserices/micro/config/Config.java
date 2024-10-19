package com.spring.microserices.micro.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
