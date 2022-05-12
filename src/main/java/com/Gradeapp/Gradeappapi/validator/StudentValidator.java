package com.Gradeapp.Gradeappapi.validator;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.Gradeapp.Gradeappapi.model.Student;
import com.Gradeapp.Gradeappapi.exception.ValidatorException;

@Validated
@Configuration
public class StudentValidator {

	public void studentFieldValidator(Student student) throws Exception {
		try {
			validName(student.getName());
			validMailId(student.getMailId());
			validDob(student.getDob());
			validGender(student.getGender());
			validContactNo(student.getContactNo());
			validFathersName(student.getFathersName());
			validMothersName(student.getMothersName());
			validAddress(student.getAddress());
		} catch (ValidatorException e) {
			throw new ValidatorException(e.getMessage());
		}

	}

	private void validAddress(String address) throws Exception {
		if (address != null && address != " " && address != "  ") {

		} else {
			throw new Exception("address should not be null");
		}

	}

	private void validMothersName(String mothersName) throws Exception {
		if (mothersName != null && mothersName != " " && mothersName != "  ") {

		} else {
			throw new Exception("father's   name should not be null");
		}

	}

	private void validFathersName(String fathersName) throws Exception {
		if (fathersName != null && fathersName != " " && fathersName != "  ") {

		} else {
			throw new Exception("The father's name should  not be null");
		}

	}

	private void validContactNo(String contactNo) throws Exception {

		char[] contact = contactNo.toCharArray();
		int count = 0;
		if (contact.length > 10 || contact.length < 10) {
			throw new Exception("Contact Number Must Be 10 Digits Long");
		}
		for (char i : contact) {
			if (Character.isAlphabetic(i)) {
				throw new Exception("Enter only Numeric values");
			} else {
				count++;
			}
		}
		if (count == 11) {

			throw new Exception("Please Enter a Valid Mobile Number");
		}
	}

	private static int validGender(String gender) throws ValidatorException {
		if (gender.equals("male") || gender.equals("female")) {
			return 1;
		} else {
			throw new ValidatorException("select a valid gender");
		}
	}

	private static int validDob(String dob) {
		return 1;
	}

	private static void validMailId(String mailId) throws ValidatorException {

		if (mailId != null && mailId.contains("@gmail.com")) {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new ValidatorException("please enter valid email ");
		}
	}

	private static void validName(String name) throws ValidatorException {
		if (name != null && name != " " && name != "  ") {
		} else {
			throw new ValidatorException("Enter a valid name");
		}
	}

	public void rollNumVaidator(Integer rollNum) throws Exception {
		if (rollNum >= 0) {

		} else {
			throw new Exception("Enter a valid roll number");
		}

	}

	public void studentValidator(Student studentobj) throws Exception {
		if (studentobj != null) {

		} else {
			throw new Exception("Enter a valid details");
		}

	}

	public void rollNumValidator(int rollNum) throws Exception {
		if(rollNum!=0) {
			
		}else {
			throw new Exception("Enter a valid rollNumber");
		}
		
	}

	public void nameValidator(String name) throws Exception {
		if(name!=null) {
			
		}else {
			throw new Exception("Enter a valid name");
		}
		
	}

}
