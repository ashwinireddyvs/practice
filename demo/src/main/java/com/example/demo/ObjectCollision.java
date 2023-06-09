package com.example.demo;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class ObjectCollision {
	public static void main(String[] args) {
		Map<Money,Voucher> map = new HashMap<Money,Voucher>();
		Money m1 =new Money("USD",80);
		Money m2 =new Money("USD",80);
		map.put(m1,new Voucher("USD",80,"Amaxon")) ;
		map.put(m2,new Voucher("USD",80,"Flipkart")) ;
		map.put(new Money("EU",80),new Voucher("EU",80,"Amazon")) ;
		System.out.println(m1.equals(m2));
		System.out.println(map);
		
	}
}

@Data
@AllArgsConstructor
class Money{
	private String currency;
	private int value;
	
}

@Data
class Voucher extends Money{
	private String store;
	
	@Builder
	public Voucher(String currency,int value,String store) {
		super(currency,value);
		store=this.store;
				
	}
}

