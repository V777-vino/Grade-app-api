package com.Gradeapp.Gradeappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Gradeapp.Gradeappapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@SuppressWarnings("rawtypes")

	public List findByName(String name);

	void deleteById(Integer rollNum);

	Optional<Student> findById(Integer rollNum);

	public Optional<Student> findByMailIdAndDob(String mailId, String dob);

	@Query(value = "SELECT student_school.roll_num, student_school.name, mark_school.term, mark_school.sub_name, mark_school.sub_id, mark_school.marks FROM student_school INNER JOIN mark_school ON student_school.roll_num = mark_school.roll_num;", nativeQuery = true)
	public List<Object> login(String mailId, String dob);
}
