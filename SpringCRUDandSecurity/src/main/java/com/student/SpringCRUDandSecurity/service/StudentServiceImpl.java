package com.student.SpringCRUDandSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.SpringCRUDandSecurity.entity.Student;
import com.student.SpringCRUDandSecurity.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> searchAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student searchById(int id) {
		Optional<Student> student;
		student = studentRepository.findById(id);
		return student.get();
	}

	@Override
	public void save(Student student) {
		
		studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);

	}

}
