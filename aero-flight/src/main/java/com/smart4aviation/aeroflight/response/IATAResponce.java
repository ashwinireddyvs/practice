package com.smart4aviation.aeroflight.response;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class IATAResponce {
	int departingFlightsCount;
	int arraivingFlightsCount;
	int arrivingBaggagesCount;
	int departingBaggageCount;
	
}
