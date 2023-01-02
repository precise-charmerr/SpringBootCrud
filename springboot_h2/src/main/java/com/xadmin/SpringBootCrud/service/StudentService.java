package com.xadmin.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xadmin.SpringBootCrud.bean.Student;
import com.xadmin.SpringBootCrud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	public StudentRepository studentRepo;

	public List<Student> getAllSubjects()
	{
		List<Student> subjects = new ArrayList<>();
		studentRepo.findAll().forEach(subjects::add);
		return subjects;
	}

	public void addSubject(Student subject) {
		studentRepo.save(subject);
		
	}

	public void updateSubject(String id, Student subject) {
		studentRepo.save(subject);
		
	}

	public void deleteSubject(String id) {
		studentRepo.deleteById(id);
		
	}
}
