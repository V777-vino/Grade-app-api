package com.Gradeapp.Gradeappapi.dto;

import com.Gradeapp.Gradeappapi.model.Student;

public class UpdateDto {

	public static void update(Student studentobj, Student student) {
		if (student.getName() != null) {
			studentobj.setName(student.getName());
		}
		if (student.getMailId() != null) {
			studentobj.setMailId(student.getMailId());
		}
		if (student.getDob() != null) {
			studentobj.setDob(student.getDob());
		}
		if (student.getGender() != null) {
			studentobj.setGender(student.getGender());
		}
		if (student.getFathersName() != null) {
			studentobj.setFathersName(student.getFathersName());
		}
		if (student.getMothersName() != null) {
			studentobj.setMothersName(student.getMothersName());
		}
		if (student.getAddress() != null) {
			studentobj.setAddress(student.getAddress());
		}

	}
}
