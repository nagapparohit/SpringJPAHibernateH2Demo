package com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

	private BigDecimal salary;
	
	protected FullTimeEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public FullTimeEmployee(String name,BigDecimal salary){
		super(name);
		this.salary = salary;
	}
	
}
