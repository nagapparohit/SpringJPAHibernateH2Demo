package com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Without entity it is like any other java bean
 * @author 91783
 *
 */
@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String rating;

	@Column
	private String description;
	
	
	
	protected Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String rating,String description) {
		this.rating = rating;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		//return "Course [id=" + id + ", name=" + name + "]";
		return String.format("Review[%s %s]",rating,description);
	}


	
	
	
	
	
}
