package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class,id);
	}
	
	/**
	 * We need to make this class transactional as itf going to modief the data.
	 * @param id
	 */
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	
	public Course save(Course course) {
		if(course.getId() == null) {
			//insert
			em.persist(course);
		}else {
			//update
			em.merge(course);
		}
		return course;
	}
	//public course findById(long id);
	//public course saveCourse(Course course) --> insert or update
	//public void deleteById
	
}
