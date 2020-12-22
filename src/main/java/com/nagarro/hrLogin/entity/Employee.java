package com.nagarro.hrLogin.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id Long id;
	private String name;
	private String location;
	private String email;
	private Date dateOfBirth;

	public Employee() {
	}

	public Employee(String name, String location, String email, Date date) {

		this.name = name;
		this.location = location;
		this.email = email;
		this.dateOfBirth = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
