package com.Gradeapp.Gradeappapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gradeapp.Gradeappapi.model.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

}
