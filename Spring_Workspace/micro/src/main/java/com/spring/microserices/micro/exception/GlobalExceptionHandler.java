package com.spring.microserices.micro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.microserices.micro.payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> handlerResourceNotFoundException(ResourceNotFoundException exception)
	{
		String msg = exception.getMessage();
		APIResponse response = APIResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
	}
}
