package com.Gradeapp.Gradeappapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gradeapp.Gradeappapi.model.Mark;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
	
	
List<Mark>  findByRollNum(Integer rolNum);
	

}
