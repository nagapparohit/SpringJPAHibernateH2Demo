package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	

	@SuppressWarnings("rawtypes")
	@Test
	void jpql_basic() {
		 Query query = em.createQuery("Select c from Course c");
		 List resultList = query.getResultList();
		 logger.info("\njpql basic\nSelect c from Course c --> \n{} ",resultList);
	}

	@Test
	void jpql_typed() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("\njpql typed\nSelect c from Course c --> \n{} ",resultList);
	}
	
	@Test
	void jpql_where() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%100 steps%'",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("\nSelect c from Course c where name like '%100 steps%'--> \n{} ",resultList);
	}
	
}
