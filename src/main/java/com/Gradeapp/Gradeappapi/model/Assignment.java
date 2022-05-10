package com.Gradeapp.Gradeappapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Assignment {

	private Integer serial_no;
	
	private Integer rollNum;
	
	private String studentName;
	
	private String description;
	
	private String status;
	
	private String assignedDate;
	
	private String endDate;
	
	

}
