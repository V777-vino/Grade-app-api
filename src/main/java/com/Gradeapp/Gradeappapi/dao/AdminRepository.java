package com.Gradeapp.Gradeappapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gradeapp.Gradeappapi.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {


	Optional<Admin> findByAdminIdAndMailId(Integer adminId, String mailId);


}
