package com.Gradeapp.Gradeappapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Gradeapp.Gradeappapi.dao.MarkRepository;
import com.Gradeapp.Gradeappapi.model.Mark;
//import com.Gradeapp.Gradeappapi.model.Student;

@RestController
public class MarkController {
	@Autowired
	MarkRepository markRepository;

	@GetMapping("mark/addmarks")
	public void addMarks(@RequestParam("rollNum") Integer rollNum, @RequestParam("term") Integer term,
			@RequestParam("subName") String subName, @RequestParam("subId") Integer subId,
			@RequestParam("marks") Integer marks) {
		Mark mark = new Mark(rollNum, term, subName, subId, marks);
		markRepository.save(mark);

	}

	@GetMapping("mark/listAllMarks")
	public List<Mark> findAll() {
		List<Mark> markList = markRepository.findAll();
		return markList;

	}

//	@PatchMapping("mark/{rollNum,term}")
//	public void updatePartially(@PathVariable("rollNum") Integer rollNum,@PathVariable("term") Integer term, @RequestBody Mark mark) {
//		mark.setRollNum(rollNum);
//		mark.setTerm(term);
//		Mark markObj = markRepository.findByRollNUmAndTerm(rollNum, term).
//		markObj.
//		markRepository.save(markObj);
//
//	}

	@GetMapping("mark/findByRollNum")
	public ResponseEntity<List<Mark>> getMarkByRollNum(@RequestParam Integer rollNum) {

		List<Mark> findByrollNunm = markRepository.findByRollNum(rollNum);

		return new ResponseEntity<List<Mark>>(findByrollNunm, HttpStatus.OK);
	}

}
