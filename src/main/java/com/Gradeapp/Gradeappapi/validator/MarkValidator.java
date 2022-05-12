package com.Gradeapp.Gradeappapi.validator;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.Gradeapp.Gradeappapi.model.Mark;

@Validated
@Configuration
public class MarkValidator {

	public static void markValidate(Mark mark) throws Exception {
		int rollNum = mark.getRollNum();
		String subName = mark.getSubName();
		int term = mark.getTerm();
		int subId = mark.getSubId();
		int marks = mark.getMarks();

		if (rollNum == 0) {
			throw new Exception("enter a valid roll number");
		} 
		if (subName.isBlank()) {
			throw new Exception("name should not be null");
		} 
		if (term == 0) {
			throw new Exception("term shoud not be zero");
		} 
		if (subId == 0) {
			throw new Exception("subject id shoud not be zero");
		} 
		if (marks == 0) {
			throw new Exception("marks shoud not be zero");
		}
	}

}
