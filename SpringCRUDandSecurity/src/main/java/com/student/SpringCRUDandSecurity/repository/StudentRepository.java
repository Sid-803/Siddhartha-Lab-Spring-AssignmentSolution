package com.student.SpringCRUDandSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.SpringCRUDandSecurity.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public Student findByFirstName(String name); 

}
