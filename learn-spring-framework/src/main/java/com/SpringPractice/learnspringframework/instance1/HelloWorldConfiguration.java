package com.SpringPractice.learnspringframework.instance1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name,int age,Address address) {}
record Address(String addressLine, String city) {}

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ashwini";
	}
	
	@Bean
	public int age() {
		return 10;
	}
	
	@Bean
	public Person person() {
		return new Person("Srihan",2,new Address("address line 2","city2"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(),age(),address());
	}
	
	@Bean
	public Person person2Parameters(String name,int age,Address address3) {
		return new Person(name,age,address3);
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("address line 1","city1");
	}
	
	@Bean(name = "address3")
	public Address address3() {
		return new Address("address line 3","city3");
	}
}
