package com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Without entity it is like any other java bean
 * @author 91783
 *
 */
@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	protected Course() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setId(long id) {
		this.id = id;
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
