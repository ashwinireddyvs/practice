package com.practice.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.practice.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleExceptions(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(
					LocalDateTime.now(),
					ex.getMessage(),
					request.getDescription(false)
				);
	
		if(ex.getClass().equals(UserNotFoundException.class))
			return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
		
			
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		//to print top most one error
		/*
		 * ErrorDetails errorDetails = new ErrorDetails( LocalDateTime.now(),
		 * ex.getFieldError().getDefaultMessage(), request.getDescription(false) );
		 */
		
		//to print all errors with count
		String exMessage ="Total Error count: "+ex.getFieldErrorCount()+"  "
		+ex.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining("     "));
	
		ErrorDetails errorDetails = new ErrorDetails( LocalDateTime.now(),
				exMessage, request.getDescription(false) );
		
				
		return new ResponseEntity<Object>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
