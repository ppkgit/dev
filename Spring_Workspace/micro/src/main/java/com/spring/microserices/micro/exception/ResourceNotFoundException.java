package com.spring.microserices.micro.exception;

public class ResourceNotFoundException extends RuntimeException{

	// Extra properties if I want to keep in future
	
	public ResourceNotFoundException()
	{
		super("Resource Not Found on server");
	}
	
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}
}
