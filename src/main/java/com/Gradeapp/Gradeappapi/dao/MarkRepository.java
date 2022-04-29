package com.Gradeapp.Gradeappapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gradeapp.Gradeappapi.model.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

}
