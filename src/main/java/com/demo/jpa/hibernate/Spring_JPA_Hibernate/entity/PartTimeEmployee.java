package com.demo.jpa.hibernate.Spring_JPA_Hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;
	
	protected PartTimeEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public PartTimeEmployee(String name,BigDecimal hourlyWage){
		super(name);
		this.hourlyWage = hourlyWage;
	}
}
