package com.smart4aviation.aeroflight.utility;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class WeightUtility {
	BigDecimal lbToKgConversionUnit = new BigDecimal(0.45359237);
	public BigDecimal lbToKg(BigDecimal lb) {
		
		return lb.multiply(lbToKgConversionUnit);
		
	}
}
