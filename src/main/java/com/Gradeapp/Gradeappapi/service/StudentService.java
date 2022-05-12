package com.Gradeapp.Gradeappapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Gradeapp.Gradeappapi.dao.StudentRepository;
import com.Gradeapp.Gradeappapi.exception.ValidatorException;
import com.Gradeapp.Gradeappapi.model.Student;
import com.Gradeapp.Gradeappapi.validator.StudentValidator;

@Configuration
public class StudentService {

	@Autowired
	StudentValidator validator;

	@Autowired
	StudentRepository studentRepository;

	public Student validatingRegistration(Student student) throws Exception {

		try {
			validator.studentFieldValidator(student);
			studentRepository.save(student);
		} catch (ValidatorException e) {
			throw new ValidatorException(e.getMessage());
		}
		return student;

	}

	public void validatinRollNumber(Integer rollNum) throws Exception {

		try {
			validator.rollNumVaidator(rollNum);
			studentRepository.deleteById(rollNum);
		} catch (ValidatorException e) {

			throw new Exception(e.getMessage());
		}

	}

	public void validateStudent(Student studentobj) throws Exception {
		try {
			validator.studentValidator(studentobj);
			studentRepository.save(studentobj);
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}

	}

	public Student findById(int rollNum) {
		try {
			validator.rollNumValidator(rollNum);
			Optional<Student> student = studentRepository.findById(rollNum);

			if (student.isPresent()) {
				return student.get();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	public Student findByName(String name) {
		try {
			validator.nameValidator(name);
			Optional<Student> student = studentRepository.findByName(name);
			if (student.isPresent()) {
				return student.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}