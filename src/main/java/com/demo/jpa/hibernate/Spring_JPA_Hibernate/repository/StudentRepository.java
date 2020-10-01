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
	
	 //persistence context will be created , its a place all the entites are stored
	public void someTranscation() {
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
