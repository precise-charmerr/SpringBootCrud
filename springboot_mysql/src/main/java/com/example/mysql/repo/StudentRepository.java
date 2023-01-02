package com.example.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysql.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findBystudentName(String student_name);
}