package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.SpringJpaHibernateApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaHibernateApplication.class)
public class CourseRepositoryTest {
	
	//so context will launched and context will be killed
	@Test
	public void contextLoads() {
		
	}
}
