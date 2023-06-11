package com.smart4aviation.aeroflight.enity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_SA_CARGO")
public class Cargo {
	
	@EmbeddedId
    private CargoId cargoId;
	
	private BigDecimal weight;
	
    private String weightUnit;
    
    private Integer pieces;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("flightId")
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;
	
}

@Embeddable
class CargoId implements Serializable {
	
	@GeneratedValue
	@Column(name="ID")
    Integer id;
    
	@Column(name="FLIGHT_ID")
    Integer flightId; 
  

    // standard getters and setters
}
