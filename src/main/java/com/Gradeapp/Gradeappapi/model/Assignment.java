package com.Gradeapp.Gradeappapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="assignment_school")
public class Assignment {
  
	@Id
	@Column(name="assignmentId")
	private Integer assignmentId;
	
	@Column(name="roll_num")
	private Integer rollNum;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="subject_name")
	private String subjectName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;

}
