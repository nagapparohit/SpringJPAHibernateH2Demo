package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Passport;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	

	//public Student findById(long id);
	public Student findById(Long id) {
		return em.find(Student.class,id);
	}
	
	/**
	 * We need to make this class transactional as itf going to modief the data.
	 * @param id
	 */
	//public void deleteById
	public void deleteById(Long id) {
		Student Student = findById(id);
		em.remove(Student);
	}
	
	//public Student saveStudent(Student Student) --> insert or update
	public Student save(Student student) {
		if(student.getId() == null) {
			//insert  we use persist for new entry in db
			em.persist(student);
		}else {
			//update
			em.merge(student);
		}
		return student;
	}
	
	//this is a transactional so entity maanger will keep track of entity
	public void saveStudentWithPassport() {
		//we need to first persist the passport in the datbase then only we can save as it passport in transient property of student
		Passport passport = new Passport("Z123456");
		em.persist(passport);
		
		Student student = new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
		
	}
}
