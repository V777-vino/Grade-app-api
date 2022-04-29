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
@Entity(name = "mark_school")
public class Mark {

	public Mark(Integer rollNum, Integer term, String subName, Integer subId, Integer marks) {
		this.rollNum = rollNum;
		this.term = term;
		this.subName = subName;
		this.subId = subId;
		this.marks = marks;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_no", insertable = false, updatable = false)
	private Integer serialNo;

	@Column(name = "roll_num")
	private Integer rollNum;

	@Column(name = "term")
	private Integer term;

	@Column(name = "sub_name")
	private String subName;

	@Column(name = "sub_id")
	private Integer subId;

	@Column(name = "marks", nullable = false)
	private Integer marks;

}
