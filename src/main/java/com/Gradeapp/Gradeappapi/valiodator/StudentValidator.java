package com.Gradeapp.Gradeappapi.valiodator;

import javax.validation.ValidationException;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.Gradeapp.Gradeappapi.model.Student;
import com.Gradeapp.Gradeappapi.exception.ValidatorException;

@Validated
@Configuration
public class StudentValidator {

	public void studentFieldValidator(Student student) throws ValidatorException {
		try {
			validName(student.getName());
			validMailId(student.getMailId());
			validDob(student.getDob());
			validGender(student.getGender());
		} catch (ValidationException e) {
			throw new ValidatorException(e.getMessage());
		}

	}

	private static int validGender(String gender) throws ValidatorException {
//		if (gender == "male" || gender == "female") {
		if (gender.equals("male") || gender.equals("female")) {
			return 1;
		} else {
			throw new ValidatorException("select a valid gender");
		}
	}

	private static int validDob(String dob) {
		return 1;
	}

	private static int validMailId(String mailId) throws ValidatorException {

		if (mailId == null || mailId.contains("@") || mailId.contains(".com")) {
			// int result = RegisterValidation.mailIdValidator(mailId);
		} else {
			throw new ValidatorException("please enter valid email ");
		}
		return 0;
	}

	private static int validName(String name) throws ValidatorException {
		if (name != null && name != " " && name != "  ") {
			return 1;
		} else {
			throw new ValidatorException("Enter a valid name");
		}

	}
}
