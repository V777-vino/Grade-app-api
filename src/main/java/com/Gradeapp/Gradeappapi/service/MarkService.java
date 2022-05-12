package com.Gradeapp.Gradeappapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Gradeapp.Gradeappapi.dao.MarkRepository;
import com.Gradeapp.Gradeappapi.model.Mark;
import com.Gradeapp.Gradeappapi.validator.MarkValidator;

@Configuration
public class MarkService {
	@Autowired
	MarkRepository markRepository;

	@Autowired
	MarkValidator markValidator;

	public void markValidate(Mark mark) throws Exception{
			MarkValidator.markValidate(mark);
//			System.out.println("hello");
			markRepository.save(mark);
		
	}

}
