package com.practice.springboot.learnjpaandhibernate.course.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.springboot.learnjpaandhibernate.course.Course;

@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{
	List<Course> findByAuthor(String author);

	List<Course> findByAuthorAndName(String author, String name);
}
