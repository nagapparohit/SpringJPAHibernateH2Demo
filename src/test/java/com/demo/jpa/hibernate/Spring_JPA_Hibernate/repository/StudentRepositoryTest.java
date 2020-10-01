package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


import com.demo.jpa.hibernate.Spring_JPA_Hibernate.SpringJpaHibernateApplication;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Passport;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Student;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaHibernateApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	//Session and Session Facotry
	//Entity Manager & persistence context
	//Trnasaction
	
	//the way we interact  with persistence context is with entity manager
	//so whenever we call entity manager we acualty playing with persistence context
	//peristence context is created at start of the trnacation and killed as soon as the trnacation is ended
	//at start of trnacation persisten context will created
	// persistence context act as store for your entites , it also give acction to datbase
	// as when we call student.getPasspor() query will be fired to datbase 
	// in JPA we use entity manager to talk to the persistence context
	//persistence context will be created , its a place all the entites are stored
	@Test
	@Transactional
	public void someTest() {
		//if no trnacation is created the each call will be acted as it own transacation
		//database operation 1 retrieve studen
		Student student = em.find(Student.class, 20001L);
		//persistence context (student)
		logger.info("\nstudent --> \n{}",student);
		
		//database operation 2 retrieve passport
		Passport passport = student.getPassport();
		//persistence context (student,passport)
		logger.info("\nstudent passport detials --> \n{}",student.getPassport());
		
		//database operation 3 update passport 
		passport.setNumber("P123456");
		//persistence context (student,passport++)
		logger.info("\nstudent passport updated detials --> \n{}",student.getPassport());
		
		//database operation 4 update student
		student.setName("Ranga -->update");
		//persistence context (student++,passport++)
		logger.info("\nstudent updated --> \n{}",student);
		
	}
	
	@Test
	@Transactional
	void retrieveStuentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student --> {}",student);
		logger.info("student passport detials --> {}",student.getPassport());		
	}
		
}
