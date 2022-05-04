package com.Gradeapp.Gradeappapi.validator;

import org.springframework.context.annotation.Configuration;

import com.Gradeapp.Gradeappapi.model.Student;

@Configuration
public class StudentValidator {

	public void studentRegValidator(Student student) throws Exception {

		if (student.getRollNum() == 0)
			throw new Exception("Invalid mailId");

		if (student.getMailId().contains("@gmail.com"))
			throw new Exception("@gmail.com");

		if (student.getName().equals(null))
			throw new Exception("Invalid name!");
		if((student.getGender()!="male") || (student.getGender()!="female"))
				throw new Exception("invalid gender");

	}
}
