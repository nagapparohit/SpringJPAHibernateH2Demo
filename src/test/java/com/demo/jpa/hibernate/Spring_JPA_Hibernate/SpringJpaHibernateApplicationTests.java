package com.demo.jpa.hibernate.Spring_JPA_Hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Course;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository.CourseRepository;

@SpringBootTest
class SpringJpaHibernateApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * sequence of event is very clear
	 * context got launched
	 * test run
	 * context got killed
	 */
	@Autowired
	CourseRepository repository;
	
	@Test
	void contextLoads() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
		//logger.info("Test is running");
		
	}

}
