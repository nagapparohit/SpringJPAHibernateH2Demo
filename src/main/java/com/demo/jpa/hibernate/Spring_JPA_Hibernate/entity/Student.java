package com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Without entity it is like any other java bean
 * @author 91783
 *
 */
@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	

	@Column(nullable =false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	protected Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	


	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		//return "Course [id=" + id + ", name=" + name + "]";
		return String.format("Student[%s]",name);
	}


	
	
	
	
	
}
