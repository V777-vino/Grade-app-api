package com.Gradeapp.Gradeappapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Gradeapp.Gradeappapi.dao.StudentRepositorys;
import com.Gradeapp.Gradeappapi.model.Student;
import com.Gradeapp.Gradeappapi.validator.StudentValidator;

@Configuration
public class StudentService {

	@Autowired
	StudentRepositorys studentRepository;

	@Autowired
	StudentValidator studentValidator;

	public Object register(Student student) {
		studentValidator.studentRegValidator(student);
		return studentRepository.save(student);
	}
}