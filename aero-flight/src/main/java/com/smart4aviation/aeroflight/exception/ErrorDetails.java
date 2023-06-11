package com.smart4aviation.aeroflight.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String details;
}
