package com.Gradeapp.Gradeappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Gradeapp.Gradeappapi.dao.MarkRepository;
import com.Gradeapp.Gradeappapi.model.Mark;

@RestController
public class MarkController {
	@Autowired
	MarkRepository markRepository;
	
	
	@GetMapping("mark/addmarks")
	public String addMarks(@RequestParam("rollNum") Integer rollNum, @RequestParam("term") Integer term,
			@RequestParam("subName") String subName, @RequestParam("subId") Integer subId,
			@RequestParam("marks") Integer marks) {
		Mark mark = new Mark(rollNum,term,subName,subId,marks);
         markRepository.save(mark);
         
         return "Success";
	}
	
	@PostMapping("mark/addMarks")
	public void addmarks(@RequestBody Mark mark) {
		markRepository.save(mark);
		
	}

}
