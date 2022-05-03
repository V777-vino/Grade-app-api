package com.Gradeapp.Gradeappapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "mark_school")
public class Mark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entry_num", insertable = false, updatable = false)
	private Integer entryNum;

	@Column(name = "roll_num", nullable = false)
	private Integer rollNum;

	@Column(name = "term", nullable = false)
	private Integer term;

	@Column(name = "sub_name", nullable = false)
	private String subName;

	@Column(name = "sub_id", nullable = false)
	private Integer subId;

	@Column(name = "marks", nullable = false)
	private Integer marks;

	public Mark(Integer rollNum, Integer term, String subName, Integer subId, Integer marks) {
		super();
		this.rollNum = rollNum;
		this.term = term;
		this.subName = subName;
		this.subId = subId;
		this.marks = marks;
	}

}
