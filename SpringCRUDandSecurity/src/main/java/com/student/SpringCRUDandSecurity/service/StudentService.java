package com.student.SpringCRUDandSecurity.service;
import java.util.List;

import com.student.SpringCRUDandSecurity.entity.Student;

public interface StudentService {
	public List<Student> searchAll();
	
	public Student searchById(int Id);
	
	public void deleteById(int id);

	public void save(Student student);
}
