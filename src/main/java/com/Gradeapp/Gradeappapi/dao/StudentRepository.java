package com.Gradeapp.Gradeappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Gradeapp.Gradeappapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@SuppressWarnings("rawtypes")
	
	public List findByName(String name);

	void deleteById(Integer rollNum);

	Optional<Student> findById(Integer rollNum);

	public Optional<Student> findByMailIdAndDob(String mailId, String dob);

}
