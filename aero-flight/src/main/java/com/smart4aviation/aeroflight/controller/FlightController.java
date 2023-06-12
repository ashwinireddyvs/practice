package com.smart4aviation.aeroflight.controller;



import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;


	/*
	 * related api's
	 * /flight --> to save the flight details
	 * /flight/{flightNumber} --> fetch details of flight for requested Flight Number and date
	 * /flight/ita --> fetch details of Airport requested IATA Airport Code and date
	 * */
 

@RestController
@Log4j2
@Tag(name = "Flight", description = "Everything about Flights")
public class FlightController {
		
	@Autowired
	private FlightService flightService;
	
	
	/* save flight details 
	 * takes flight object as input
	 * */ 
	@PostMapping("/flight")
	public void saveFlight(@RequestBody Flight flight) {
		log.info("Inside saveFlight method");
		flightService.save(flight);
	}
	
	/*
	 * For requested Flight Number and date will respond with following : 
	 * a. Cargo Weight for requested Flight 
	 * b. Baggage Weight for requested Flight 
	 * c. Total Weight for requested Flight
	 */
	@Operation(summary = "Get Flight weight details", description = "Fetch Flight weight details using flight Number and date")
	@GetMapping("/flight/{flightNumber}")
	public FlightWeight retrieveFlightWeight(
			@Parameter(description = "Fight Departure DateTime Eg. 2018-12-17T09:05:51-01:00")
			@RequestParam("Departure DateTime(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)") OffsetDateTime departureDate,
			@Parameter(description = "Fight Number Eg. 8703")
			@PathVariable Integer flightNumber) {
		log.info("Inside retrieveFlightWeight method");
		return flightService.retrieveFlightIdByNoNDate(flightNumber,departureDate);
			
	}
	
	/*
	 * For requested IATA Airport Code and date will respond with following :
	 * a. Number of flights departing from this airport, 
	 * b. Number of flights arriving to this airport, 
	 * c. Total number (pieces) of baggage arriving to this airport, 
	 * d. Total number (pieces) of baggage departing from this airport.
	 */
	@Operation(summary = "Get Aorport details", description = "Fetch Airport details using airport IATA code and date")
	@GetMapping("/flight/ita")
	public IATAResponce retrieveITADetails(
			@Parameter(description = "Airport details at specific DateTime Eg. 2018-12-17T09:05:51-01:00")
			@RequestParam("DateTime(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)") OffsetDateTime departureDate,
			@Parameter(description = "IATA code Eg. YYT")
			@RequestParam("IATA code") String iataCode) {
		log.info("Inside retrieveITADetails method");
				return flightService.retrieveIATADetailsByITACodeNDate(iataCode,departureDate);
		
	}
	
	
	
	
}
