package com.smart4aviation.aeroflight.enity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_SA_FLIGHT")
public class Flight {
	
	@Id
	@GeneratedValue
	private Integer flightId;
	
	@NonNull
	private Integer flightNumber;
	
	@NonNull
	private String departureAirportIATACode;
	
	@NonNull
	private String arrivalAirportIATACode;
	
	@NonNull
	private OffsetDateTime departureDate;
	
	@OneToMany(mappedBy = "flight")
	private List<Baggage> baggageList;
	
	@OneToMany(mappedBy = "flight")
	private List<Cargo> cargoList;
}
