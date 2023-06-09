package com.practice.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CourseJpaRepository {
	
	//@Autowired can use autowire too, but more specific usinf PersistenceContext ->Expresses a dependency on a container-managed EntityManager and itsassociated persistence context.
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class,id);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class,id);
		entityManager.remove(course);
	}
}
