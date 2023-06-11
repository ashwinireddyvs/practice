package com.smart4aviation.aeroflight.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Component;

import com.smart4aviation.aeroflight.enity.Flight;
import com.smart4aviation.aeroflight.response.FlightWeight;
import com.smart4aviation.aeroflight.response.IATAResponce;

public interface FlightService {

	

	public void save(Flight flight);


	public FlightWeight retrieveFlightIdByNoNDate(Integer flightNumber, OffsetDateTime departureDate);


    public IATAResponce retrieveIATADetailsByITACodeNDate(String itaCode, OffsetDateTime departureDate); 
	
	
}
