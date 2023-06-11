package com.smart4aviation.aeroflight.controller;



import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart4aviation.aeroflight.enity.Flight;
import com.smart4aviation.aeroflight.response.FlightWeight;
import com.smart4aviation.aeroflight.response.IATAResponce;
import com.smart4aviation.aeroflight.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightWeight flightWeight;
	
	@Autowired
	private FlightService flightService;
	
	
	
	@PostMapping("/flight")
	public void saveFlight(@RequestBody Flight flight) {
		flightService.save(flight);
	}
	
	
	@GetMapping("/flight/{flightNumber}")
	public FlightWeight retrieveFlightWeight(@RequestParam OffsetDateTime departureDate,
			@PathVariable Integer flightNumber) {
		return flightService.retrieveFlightIdByNoNDate(flightNumber,departureDate);
			
	}
	
	@GetMapping("/flight/ita")
	public IATAResponce retrieveITADetails(@RequestParam OffsetDateTime departureDate,
			@RequestParam String iataCode) {
				return flightService.retrieveIATADetailsByITACodeNDate(iataCode,departureDate);
		
	}
	
	
	
	
}
