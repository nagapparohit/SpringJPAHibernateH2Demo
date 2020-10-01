package com.demo.jpa.hibernate.Spring_JPA_Hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Course;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository.CourseRepository;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository.StudentRepository;

@SpringBootApplication
public class SpringJpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public CourseRepository courseRepository;
	
	@Autowired
	public StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.saveStudentWithPassport();
	}

}
