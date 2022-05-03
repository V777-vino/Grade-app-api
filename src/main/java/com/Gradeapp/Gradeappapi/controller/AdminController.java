package com.Gradeapp.Gradeappapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Gradeapp.Gradeappapi.dao.AdminRepository;
import com.Gradeapp.Gradeappapi.model.Admin;

@RestController
public class AdminController {

	@Autowired
	AdminRepository adminRepository;

	@PostMapping("admin/login")
	public Admin login(@RequestBody Admin admin) {
		Optional<Admin> adminLogin = adminRepository.findByAdminIdAndMailId(admin.getAdminId(),admin.getMailId());
		return adminLogin.get();
	}
}
