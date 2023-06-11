package com.smart4aviation.aeroflight.response;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class FlightWeight {
	private BigDecimal baggageWeight;
	private BigDecimal cargoWeight;
	private BigDecimal totalWeight;
	private String weightUnit;
}
