package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	
	private String firstName;
	private String lastName;
	private String email;
	private String clgName;
	
	
	//default constructor
	public Student() {
		
	}
	
	
	//Parameterized constructor
	public Student(String firstName, String lastName, String email, String clgName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.clgName = clgName;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getClgName() {
		return clgName;
	}


	public void setClgName(String clgName) {
		this.clgName = clgName;
	}
	
	
	
	
	
}
