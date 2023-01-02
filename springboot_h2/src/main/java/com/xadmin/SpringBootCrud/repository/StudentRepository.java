package com.xadmin.SpringBootCrud.repository;

import org.springframework.data.repository.CrudRepository;
import com.xadmin.SpringBootCrud.bean.Student;

public interface StudentRepository extends CrudRepository<Student,String> {
	

}
