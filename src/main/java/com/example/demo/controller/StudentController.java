package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentServices;

import jakarta.servlet.http.HttpSession;



@Controller
public class StudentController {
	
	
	private StudentServices StudentServices;

	//constructor
	public StudentController(StudentServices StudentServices) {
		super();
		this.StudentServices = StudentServices;
	}
	
	
	//handler to remove popup success message as blank 
	@PostMapping("/resetSuccessMessage")
	public ResponseEntity<Void> resetSuccessMessage(HttpSession session) {
		session.removeAttribute("successMessage");
	    return ResponseEntity.ok().build();
	}
	
	
	//handler method to handle the list of students and return model and view
	
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		model.addAttribute("students", StudentServices.getAllStudents());
		return "Student";
	}
	
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("students", student);
		return "create_student";
	}
	
	
	//to save new data through create_student.html from into repo 
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student, HttpSession session) {
		StudentServices.saveStudent(student);
		session.setAttribute("successMessage", "Successfully Added");
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", StudentServices.getStudentById(id));
		return "edit_student";
	}
	
	
	
	//update method handler
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model, HttpSession session) {
		//first get student from database by id and then save 
		Student existingStudent = StudentServices.getStudentById(id);
		
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setClgName(student.getClgName());
		
		//Now data has been edited 
		//so no update this by calling update function
		
		StudentServices.updateStudent(existingStudent);
		session.setAttribute("successMessage", "Successfully Updated");
		
		return "redirect:/students";	
	}
	
	//handler method for delete student
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id, HttpSession session) {
		StudentServices.deleteStudentById(id);
		session.setAttribute("successMessage", "Successfully deleted");
		return "redirect:/students";
	}
	
	
	
	
	
	
	

	
}