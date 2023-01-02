package com.example.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.Book;
import com.example.mysql.model.Student;
import com.example.mysql.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/studentSave")
	public String insertStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Student data saved successfully";
	}
	
	@PostMapping("/multipleStudentSave")
	public String insertManyStudent(@RequestBody List<Student> student) {
		studentRepository.saveAll(student);
		return "Many Students saved successfully";
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getStudent() {
		return (List<Student>) studentRepository.findAll();
	}
	
	@GetMapping("/getByStudentId/{studentId}")
	public Optional<Student> getStudentbyId(@PathVariable("studentId") long id) {
		return studentRepository.findById(id);
	}
	
	@GetMapping("/getByStudentName/{name}")
	public List<Student> getStudentbyName(@PathVariable("name") String student_name) {
		return (List<Student>) studentRepository.findBystudentName(student_name);
	}
	
	@PutMapping("/UpdateStudentById/{id}")
	public void UpdateDataById(@RequestBody Student student, @PathVariable("id") long id) {
		student.setStudentId(id);
		studentRepository.save(student);
	}
	
	@DeleteMapping("/DeleteStudentById/{id}")
	public void DeleteStudentById(@PathVariable("id") long id) {
		studentRepository.deleteById(id);
	}
}
