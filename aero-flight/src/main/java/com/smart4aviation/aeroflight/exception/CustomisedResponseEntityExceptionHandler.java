package com.smart4aviation.aeroflight.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleExceptions(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(
					LocalDateTime.now(),
					ex.getMessage(),
					request.getDescription(false)
				);

		if(ex.getClass().equals(FlightNotFountException.class))
			return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);


		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
