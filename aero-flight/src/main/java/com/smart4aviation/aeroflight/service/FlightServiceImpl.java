package com.smart4aviation.aeroflight.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart4aviation.aeroflight.controller.FlightController;
import com.smart4aviation.aeroflight.enity.Baggage;
import com.smart4aviation.aeroflight.enity.Cargo;
import com.smart4aviation.aeroflight.enity.Flight;
import com.smart4aviation.aeroflight.exception.FlightNotFountException;
import com.smart4aviation.aeroflight.repository.FlightRepository;
import com.smart4aviation.aeroflight.response.FlightWeight;
import com.smart4aviation.aeroflight.response.IATAResponce;
import com.smart4aviation.aeroflight.utility.WeightUtility;
import com.smart4aviation.aeroflight.utility.weightUnit;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightWeight flightWeight;

	@Autowired
	private IATAResponce iataResponce;

	@Autowired
	private WeightUtility weightUtility;

	@Override
	public void save(Flight flight) {
		// TODO Auto-generated method stub
		flightRepository.save(flight);
	}

	@Override
	public FlightWeight retrieveFlightIdByNoNDate(Integer flightNumber, OffsetDateTime departureDate) {
	
		log.info("Inside retrieveFlightIdByNoNDate method");
		Optional<Flight> optional = flightRepository.findByFlightNumberAndDepartureDate(flightNumber, departureDate);

		if (optional.isPresent())
		{
			Flight flight = optional.get();
			List<Baggage> baggageList = flight.getBaggageList();
			List<Cargo> cargoList = flight.getCargoList();

			BigDecimal totalBaggageWeight = 
					baggageList.stream() 
					.map( x -> {
						if(x.getWeightUnit().equalsIgnoreCase(weightUnit.LB.toString()))
							x.setWeight(weightUtility.lbToKg(x.getWeight()));
						return x;
					})
					.map(Baggage::getWeight)
					.map(x -> x.add(x))
					.reduce((x, y) -> x.add(y)).get();

			BigDecimal totalCargoWeight = cargoList.stream() 
					.map( x -> {
						if(x.getWeightUnit().equalsIgnoreCase(weightUnit.LB.toString())) 
							x.setWeight(weightUtility.lbToKg(x.getWeight()));
						return x;
					})
					.map(Cargo::getWeight)
					.map(x -> x.add(x))
					.reduce((x, y) -> x.add(y)).get();

			flightWeight.setBaggageWeight(totalBaggageWeight);
			flightWeight.setCargoWeight(totalCargoWeight);

			flightWeight.setTotalWeight(totalCargoWeight.add(totalBaggageWeight));

			flightWeight.setWeightUnit(weightUnit.KG.toString());

			return flightWeight;

		}
		else
			throw new FlightNotFountException("Flight details not found");

	}

	@Override
	public IATAResponce retrieveIATADetailsByITACodeNDate(String itaCode, OffsetDateTime departureDate) {
		// TODO Auto-generated method stub
		log.info("Inside retrieveIATADetailsByITACodeNDate method");
		List<Flight> departingFlights = flightRepository.findAllByDepartureAirportIATACodeAndDepartureDate(itaCode,
				departureDate);
		List<Flight> arrivingFlights = flightRepository.findAllByArrivalAirportIATACodeAndDepartureDate(itaCode,
				departureDate);

		if (departingFlights != null && !departingFlights.isEmpty()) {
			iataResponce.setDepartingFlightsCount(departingFlights.size());
			iataResponce.setDepartingBaggageCount(countOfBaggage(departingFlights));
		}

		if (arrivingFlights != null && !arrivingFlights.isEmpty()) {
			iataResponce.setArraivingFlightsCount(arrivingFlights.size());
			iataResponce.setDepartingBaggageCount(countOfBaggage(arrivingFlights));
		}
		return iataResponce;
	}

	public int countOfBaggage(List<Flight> flights) {
		log.info("Inside countOfBaggage method");
		int count = 0;
		count = flights.stream()
				.map(Flight::getBaggageList)
				.flatMap(List::stream)
				.map(Baggage::getPieces)
				.reduce((x, y) -> x + y).get();

		return count;
	}

}
