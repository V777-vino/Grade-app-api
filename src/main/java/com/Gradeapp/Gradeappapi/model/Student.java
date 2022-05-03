package com.Gradeapp.Gradeappapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

//	@OneToMany(targetEntity = Mark.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "sm_fk", referencedColumnName = "roll_num")
//	private List<Mark> Marks;

}
