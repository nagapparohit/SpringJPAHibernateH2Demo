package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	

	@SuppressWarnings("rawtypes")
	@Test
	void native_queries_basic() {
		 Query query = em.createNativeQuery("Select * from Course",Course.class);
		 List resultList = query.getResultList();
		 logger.info("\nNative  basic\nSelect * from Course  --> \n{} ",resultList);
	}
	
	@Test
	void native_queries_with_parameter() {
		 Query query = em.createNativeQuery("Select * from Course where id = ?",Course.class);
		 query.setParameter(1, 10001L);
		 List resultList = query.getResultList();
		 logger.info("\nNative  basic\nSelect * from Course where id = ? --> \n{} ",resultList);
	}
	
	
	@Test
	void native_queries_with_named_parameter() {
		 Query query = em.createNativeQuery("Select * from Course where id = :id",Course.class);
		 query.setParameter("id", 10001L);
		 List resultList = query.getResultList();
		 logger.info("\nNative  basic\nSelect * from Course where id = :id --> \n{} ",resultList);
	}
	
}
