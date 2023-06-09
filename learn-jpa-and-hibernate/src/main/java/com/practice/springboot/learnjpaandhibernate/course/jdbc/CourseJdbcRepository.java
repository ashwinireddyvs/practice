package com.practice.springboot.learnjpaandhibernate.course.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practice.springboot.learnjpaandhibernate.course.Course;



@Repository
public class CourseJdbcRepository {
	
	Logger logger = LoggerFactory.getLogger(CourseJdbcRepository.class);
	
	//for using spring JDBCTemplate
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	

	
	private static String INSERT_QUERY=
			"""
			insert into course (id, name, author)
			values (? , ? , ? );
							
			""";
	
	private static String DELETE_QUERY=
			"""
			delete from course where id =?;
							
			""";
	
	private static String SELECT_QUERY="""
			select * from course
			where id = ?;
			""";
	
	//to run this query at the start up of the application can be done by CommandLineRunner, refer CourseJdbcCommandLineRunner class
	public void insert(Course course) {
		logger.info("Query insert ==> " + INSERT_QUERY);
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id) {
		logger.info("Query delete ==> " + INSERT_QUERY);
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(long id) {
		//map ResultSet to Bean using RowMapper
		//send id as parameter
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),id);
		
	}
}
