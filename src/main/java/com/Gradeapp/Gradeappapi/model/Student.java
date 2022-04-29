package com.Gradeapp.Gradeappapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student_school")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roll_num", insertable = false, updatable = false)
	private Integer rollNum;

	@Column(name = "name")
	private String name;

	@Column(name = "mail_id")
	private String mailId;

	@Column(name = "dob")
	private String dob;

	@Column(name = "gender")
	private String gender;

}
