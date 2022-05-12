package com.Gradeapp.Gradeappapi.validator;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.Gradeapp.Gradeappapi.model.Mark;

@Validated
@Configuration
public class MarkValidator {

	public static void markValidate(Mark mark) throws Exception {
		Mark m = new Mark();
		Integer rollNum = m.getRollNum();
		String subName = m.getSubName();
		Integer term = m.getTerm();
		Integer subId = m.getSubId();
		Integer marks = m.getMarks();

		if (rollNum != 0) {

		} else {
			throw new Exception("valid new roll number");
		}
		if (subName != null) {

		} else {
			throw new Exception("name should not be null");
		}
		if (term != 0) {

		} else {
			throw new Exception("term shoud not be zero");
		}
		if (subId != 0) {

		} else {
			throw new Exception("subject id shoud not be zero");
		}
		if (marks != 0) {

		} else {
			throw new Exception("marks shoud not be zero");
		}

	}

}
