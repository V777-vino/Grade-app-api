package com.Gradeapp.Gradeappapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Gradeapp.Gradeappapi.dao.StudentRepository;
import com.Gradeapp.Gradeappapi.dto.UpdateDto;
import com.Gradeapp.Gradeappapi.message.Message;
import com.Gradeapp.Gradeappapi.model.Student;
import com.Gradeapp.Gradeappapi.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	
	
	

//	@PostMapping("student/login")
//	public List<Object> returnAll(@RequestBody Student student) throws Exception {
////		Validator.loginValidator(student);
//		studentService.valid
//		List<Object> list = studentRepository.login(student.getMailId(), student.getDob());
//		return list;
////		return  null;
//
//	}
  
//	 public Object login(@RequestBody User user) {
//		 
//	 }

	@PostMapping("students/reigster")
	public Object register(@RequestBody Student student) throws Exception {
		Object result = null;
		Message message = new Message();
		try {
			String mail = student.getMailId();

			Student n = studentRepository.findByMailId(mail);

			Student m = studentRepository.findByContactNo(student.getContactNo());

			if (n == null && m == null) {

				result = studentService.validatingRegistration(student);
			}
			System.out.println(student);

			return result;

		} catch (Exception e) {

			message.setMessage(e.getMessage());
			return message;
		}

	}

	@GetMapping("students/listStudents")
	public List<Student> findAll() {
		List<Student> StudentsList = null;
		try {
			StudentsList = studentRepository.findAll();
			if (StudentsList == null) {

				throw new Exception("There is no data");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return StudentsList;

	}

	@DeleteMapping("students/{rollNum}")
	public Message delete(@PathVariable("rollNum") Integer rollNum) {
		Message message = new Message();
		String res = null;
		try {
			studentService.validatinRollNumber(rollNum);
			res = "student details deleted";

		} catch (Exception e) {
			message.setMessage(e.getMessage());
			return message;
		}
		message.setMessage(res);
		return message;

	}

	@PatchMapping("students/{rollNum}")
	public Message updatePartially(@PathVariable("rollNum") Integer rollNum, @RequestBody Student student) {
		Message message = new Message();
		String res = null;
		student.setRollNum(rollNum);
		Student studentobj = studentRepository.findById(rollNum).get();
		UpdateDto.update(studentobj, student);
		try {
			studentService.validateStudent(studentobj);
			res = "details updated";
		} catch (Exception e) {
			message.setMessage(e.getMessage());
			return message;
		}
		message.setMessage(res);
		return message;
	}

	@GetMapping("students/findByName")
	public ResponseEntity<?> getStudentsByName(@RequestParam String name) {
		Student student = studentService.findByName(name);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		}

		return new ResponseEntity<>("invalid name", HttpStatus.OK);
	}

	@GetMapping("students/{rollNum}")
	public ResponseEntity<?> findById(@PathVariable("rollNum") Integer rollNum) {
		Student student = studentService.findById(rollNum);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		return new ResponseEntity<>("Invalid roll number", HttpStatus.BAD_REQUEST);
	}

//	@PostMapping("student/login")
//	public List<Object> returnAll(@RequestBody Student student) throws Exception {
////		Validator.loginValidator(student);
//		studentService.valid
//		List<Object> list = studentRepository.login(student.getMailId(), student.getDob());
//		return list;
////		return  null;
//
//	}

}