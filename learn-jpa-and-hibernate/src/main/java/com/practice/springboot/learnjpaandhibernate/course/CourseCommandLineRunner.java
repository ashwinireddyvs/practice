package com.practice.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.practice.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.practice.springboot.learnjpaandhibernate.course.springDataJpa.CourseSpringDataJpaRepository;

//to run this query at the start up of the application can be done by CommandLineRunner
@Component
public class CourseCommandLineRunner  implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;
	
	/*
	 * @Autowired 
	 * private CourseJpaRepository repository;
	 */
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		repository.save(new Course(1,"Learn AWS", "Ashwini"));
		repository.save(new Course(2,"Learn AWS2", "Ashwini"));
		repository.save(new Course(3,"Learn AWS3", "Ashwini"));
		
		repository.deleteById(2L);
		
		System.out.println(repository.findById(3L));
		System.out.println(repository.findById(2L));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("Ashwini"));
		
		System.out.println(repository.findByAuthorAndName("Ashwini","Learn AWS"));
		
		
	}

}
