package com.Gradeapp.Gradeappapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity(name = "mark_school")
public class Mark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entry_num", insertable = false, updatable = false)
	private int entryNum;

	@Column(name = "roll_num")
	private int rollNum;

	@Column(name = "term")
	private int term;

	@Column(name = "sub_name")
	private String subName;

	@Column(name = "sub_id")
	private int subId;

	@Column(name = "marks")
	private int marks;

	public Mark(int rollNum, Integer term, String subName, Integer subId, Integer marks) {
		super();
		this.rollNum = rollNum;
		this.term = term;
		this.subName = subName;
		this.subId = subId;
		this.marks = marks;
	}

}
