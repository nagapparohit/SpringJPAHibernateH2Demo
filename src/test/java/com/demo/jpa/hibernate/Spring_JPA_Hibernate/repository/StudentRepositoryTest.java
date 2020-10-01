package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.SpringJpaHibernateApplication;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Student;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaHibernateApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	void retrieveStuentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student --> {}",student);
		logger.info("student passport detials --> {}",student.getPassport());		
	}
		
}
