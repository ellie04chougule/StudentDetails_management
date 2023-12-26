package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentServices {
	
	//list of students
	List<Student> getAllStudents();
	
	//for creating and saving data into repository
	Student saveStudent(Student student);
	
	//to get id 
	//For update purpose
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	
	//delete method
	void deleteStudentById(Long id);
}