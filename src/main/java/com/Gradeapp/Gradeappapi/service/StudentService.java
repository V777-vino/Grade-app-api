package com.Gradeapp.Gradeappapi.service;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Gradeapp.Gradeappapi.dao.StudentRepository;
import com.Gradeapp.Gradeappapi.exception.ValidatorException;
import com.Gradeapp.Gradeappapi.message.Message;
import com.Gradeapp.Gradeappapi.model.Student;
import com.Gradeapp.Gradeappapi.valiodator.StudentValidator;

@Configuration
public class StudentService {
	
	@Autowired
	StudentValidator validator;
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student validatingRegistration(Student student) throws ValidatorException {
		
		Message message = new Message();
		Student stu = new Student();
		try {
		validator.studentFieldValidator(student);
		
		 stu = studentRepository.save(student);
		}catch(ValidatorException e) {
			throw new ValidatorException(e.getMessage());
			
		}
		return stu;

	}

	
}