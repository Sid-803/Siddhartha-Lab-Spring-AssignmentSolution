package com.student.SpringCRUDandSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import com.student.SpringCRUDandSecurity.entity.Student;
import com.student.SpringCRUDandSecurity.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/printstudents")
	public String printStudents(Model theModel) {

		List<Student> students = studentService.searchAll();
		theModel.addAttribute("Students", students);
		return "list-Student";
	}

	@GetMapping("/save")
	public String form(Model theModel) {
		Student studentOBJ = new Student();
		// studentOBJ.setFirstName("Siddhartha");
		theModel.addAttribute("Student", studentOBJ);
		return "form-Student";
	}

	@PostMapping("/saveForm")
	public String saveStudent(@RequestParam("id") int theid, @RequestParam("firstName") String fname,
			@RequestParam("lastName") String lname, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student studentOBJ = new Student();
		if (theid != 0) {
			studentOBJ.setId(theid);
			studentOBJ.setFirstName(fname);
			studentOBJ.setLastName(lname);
			studentOBJ.setCourse(course);
			studentOBJ.setCountry(country);
			studentService.save(studentOBJ);
		} else {
			// save the record in DB via object of Entity class.
			studentOBJ.setFirstName(fname);
			studentOBJ.setLastName(lname);
			studentOBJ.setCourse(course);
			studentOBJ.setCountry(country);
			studentService.save(studentOBJ);
		}

		// return to list of students
		return "redirect:/students/printstudents"; 
	}

	@GetMapping("/update")
	public String updateStudent(Model theModel, @RequestParam("studentId") int theid) {
		Student student = studentService.searchById(theid);
		theModel.addAttribute("Student", student);
		return "form-Student";
	}

	@GetMapping("/delete")
	public String deleteStudent(Model theModel, @RequestParam("studentId") int theid) {
		studentService.deleteById(theid);
		return "redirect:/students/printstudents";
	}
}
