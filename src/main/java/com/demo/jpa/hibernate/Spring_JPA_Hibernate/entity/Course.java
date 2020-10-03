package com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Without entity it is like any other java bean
 * @author 91783
 *
 */
@Entity
@NamedQueries(value = {
		@NamedQuery(name="query_get_all_courses", query = "Select c from Course c"),
		@NamedQuery(name="query_get_100_step_courses",query="Select c from Course c where name like '%100 steps%'")
		})
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	

	@Column(nullable =false)
	private String name;
	
	
	@OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
	private List<Review> reviews = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime  lastUpdatedDate;
	
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	protected Course() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}


	
	
	
	
	
}
