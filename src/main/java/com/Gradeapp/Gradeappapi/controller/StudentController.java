package com.Gradeapp.Gradeappapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Gradeapp.Gradeappapi.dao.StudentRepository;
import com.Gradeapp.Gradeappapi.model.Student;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@PostMapping("students/registerStudent")
	public void register(@RequestBody Student student) {

		studentRepository.save(student);

	}

	@GetMapping("students/listStudents")
	public List<Student> findAll() {
		List<Student> StudentsList = studentRepository.findAll();
		return StudentsList;

	}

	@DeleteMapping("students/{rollNum}")
	public void delete(@PathVariable("rollNum") Integer rollNum) {
		studentRepository.deleteById(rollNum);

	}

	@PutMapping("students/{rollNum}")
	public void update(@PathVariable("rollNum") Integer rollNum, @RequestBody Student student) {
		student.setRollNum(rollNum);
		studentRepository.save(student);

	}

	@PatchMapping("students/{rollNum}")
	public void updatePartially(@PathVariable("rollNum") Integer rollNum, @RequestBody Student student) {
		student.setRollNum(rollNum);
		Student studentobj = studentRepository.findById(rollNum).get();
		studentobj.setName(student.getName());
		studentRepository.save(studentobj);

	}

	@PostMapping("students/login")
	public Student login(@RequestBody Student student) {
		Optional<Student> studentObj = studentRepository.findByMailIdAndDob(student.getMailId(), student.getDob());
		return studentObj.get();

	}

	@SuppressWarnings("unchecked")
	@GetMapping("students/findByName")
	public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name) {

		return new ResponseEntity<List<Student>>((studentRepository.findByName(name)), HttpStatus.OK);
	}

	@GetMapping("students/{rollNum}")
	public Student findById(@PathVariable("rollNum") Integer rollNum) {
		Optional<Student> student = studentRepository.findById(rollNum);
		if (student.isPresent()) {
			Student studentObj = student.get();
			return studentObj;
		} else {
			System.out.println("Invalid credentials");
			return null;
		}

	}
}