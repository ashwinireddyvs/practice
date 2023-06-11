package com.smart4aviation.aeroflight.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart4aviation.aeroflight.enity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{


	Optional<Flight> findByFlightNumberAndDepartureDate(Integer flightNumber, OffsetDateTime departureDate);

	List<Flight> findAllByDepartureAirportIATACodeAndDepartureDate(String itaCode, OffsetDateTime departureDate);

	List<Flight> findAllByArrivalAirportIATACodeAndDepartureDate(String itaCode, OffsetDateTime departureDate);


	
}
