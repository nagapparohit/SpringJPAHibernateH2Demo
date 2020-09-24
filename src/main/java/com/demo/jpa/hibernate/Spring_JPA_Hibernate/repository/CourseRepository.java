package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Course;

@Repository
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class,id);
	}
	
	//public course findById(long id);
	//public course saveCourse(Course course) --> insert or update
	//public void deleteById
	
}
