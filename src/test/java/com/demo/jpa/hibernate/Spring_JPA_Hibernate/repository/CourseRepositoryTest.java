package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.SpringJpaHibernateApplication;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Course;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaHibernateApplication.class)
public class CourseRepositoryTest {

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
	void findById_BasicTest() {
		logger.info("Test is running");
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
		
	}

}
