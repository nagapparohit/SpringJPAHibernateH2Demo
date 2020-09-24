package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	

	//public course findById(long id);
	public Course findById(Long id) {
		return em.find(Course.class,id);
	}
	
	/**
	 * We need to make this class transactional as itf going to modief the data.
	 * @param id
	 */
	//public void deleteById
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	//public course saveCourse(Course course) --> insert or update
	public Course save(Course course) {
		if(course.getId() == null) {
			//insert  we use persist for new entry in db
			em.persist(course);
		}else {
			//update
			em.merge(course);
		}
		return course;
	}
	
	//this is a transactional so entity maanger will keep track of entity
	public void playWithEntityManager() {
		logger.info("play with entity manager --> start");
		Course c = new Course("web services in 100 steps");
		em.persist(c);
		c.setName("web service 100 stpe updated");
	}
}
