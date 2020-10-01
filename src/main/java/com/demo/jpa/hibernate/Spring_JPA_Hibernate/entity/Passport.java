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
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	

	@Column(nullable =false)
	private String number;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Student student;
	
	
	
	protected Passport() {
		// TODO Auto-generated constructor stub
	}

	public Passport(String number) {
		this.number = number;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	@Override
	public String toString() {
		//return "Course [id=" + id + ", name=" + name + "]";
		return String.format("Passport Number[%s]",number);
	}

}
