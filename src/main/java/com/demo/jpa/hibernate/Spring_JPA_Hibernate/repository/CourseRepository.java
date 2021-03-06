package com.demo.jpa.hibernate.Spring_JPA_Hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Course;
import com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	

	//public course findById(long id);
	public Course findById(Long id) {
		return em.find(Course.class,id);
	}
	
	/**
	 * We need to make this class transactional as itf going to modief the data.
	 * @param id
	 */
	//public void deleteById
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	//public course saveCourse(Course course) --> insert or update
	public Course save(Course course) {
		if(course.getId() == null) {
			//insert  we use persist for new entry in db
			em.persist(course);
		}else {
			//update
			em.merge(course);
		}
		return course;
	}
	
	public void addHardCodedReviewsForCourse() {
		//get course 10003
		Course course = findById(10003L);
		logger.info("\ncourse.getReviews()\n{}",course.getReviews());
		
		//add 2 reviews to it
		Review r1 = new Review("5","great hands on stuff");
		Review r2 = new Review("5","Hats off");

		//setting the relation ship
		course.addReview(r1);
		r1.setCourse(course);
		
		course.addReview(r2);
		r2.setCourse(course);
		
		//save it to database
		em.persist(r1);
		em.persist(r2);
		
	}
	
	
	
	public void addReviewsForCourse(Long courseId,List<Review> reviews){
		//get course 10003
		Course course = findById(courseId);
		logger.info("\ncourse.getReviews()\n{}",course.getReviews());
		
		for(Review r :reviews) {
			course.addReview(r);
			r.setCourse(course);
			em.persist(r);
		}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//this is a transactional so entity maanger will keep track of entity
	public void playWithEntityManager() {
		logger.info("play with entity manager --> start");
		//below you see can see that as 4 separate transacation as we using flush method
		Course c1 = new Course("web services in 100 steps");
		em.persist(c1);

		
		Course c2 = findById(10001L);
		c2.setName("JPA in 50 steps updated");
		//Course c2 = new Course("Angular js in 100 steps");
		
		//em.persist(c2);
		
		//em.flush();
		
		//em.clear();
		//now i dont want course 2 changes to be updated in db , so what we can do is
		//em.detach(c2); //now entity manager wil no longer track  course 2
		//em.detach(c1);

		//below update wont saved to the database as objects are detached , now these are not tracking
		//other way to untrack objects by entity manager is by clear() method
		//c1.setName("web service 100 steps updated");
		//em.flush();
		
		//c2.setName("Angular js in  100 step updated");
		//em.flush();
		
	}
}
