package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Course;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Employee;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Review;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	//insert an employee
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
	//retrive all eployee
	public List<Employee> retireveAllEmployees(){
		return em.createQuery("select e from Employee e",Employee.class).getResultList();
	}
		
}
