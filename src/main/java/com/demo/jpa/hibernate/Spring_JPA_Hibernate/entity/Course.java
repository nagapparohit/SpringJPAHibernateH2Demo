package com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Without entity it is like any other java bean
 * @author 91783
 *
 */
@Entity
@Table(name="courseDetails")
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	protected Course() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
