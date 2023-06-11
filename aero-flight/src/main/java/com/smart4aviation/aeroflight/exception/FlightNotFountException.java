package com.smart4aviation.aeroflight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FlightNotFountException extends RuntimeException {
	
	public FlightNotFountException(String message) {
		super(message);
	}
	
}
