package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.StudentServices;


@Service
public class StudentServicesImpl implements StudentServices{
	
	private StudentRepository StudentRepository;

	
	//constructor
	public StudentServicesImpl(StudentRepository StudentRepository) {
		super();
		this.StudentRepository = StudentRepository;
	}


	//it will return all the data from the repository
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return StudentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		return StudentRepository.save(student);
	}


	//Get student id from repo
	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return StudentRepository.findById(id).get();
	}


//	Now Save updated data into repo 
	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return StudentRepository.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		StudentRepository.deleteById(id);
		
	}


	
}