package com.practice.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	@RequestMapping("/courses")
	public List<Course> retieveAllCourses(){
		return Arrays.asList(
					new Course(1,"course 1","ashwini"),
					new Course(2,"course 2","Srihan")
				);
	}
	
	@RequestMapping("/currencyConfiguration")
	public CurrencyServiceConfiguration retieveCurrencyConfigurations(){
		return configuration;
	}
	
}
