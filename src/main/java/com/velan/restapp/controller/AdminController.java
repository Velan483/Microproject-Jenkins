package com.velan.restapp.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.velan.restapp.model.Admin;
import com.velan.restapp.serviceimp.AdminServiceImp;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {

	@Autowired
	AdminServiceImp service;
	
	@PostMapping("/login")
	public String Adminlogin(@RequestBody Admin admin) {
		Optional<Admin> adminUser = service.authenticate(admin.getEmail(), admin.getPassword());
		if (adminUser.isPresent()) {
			return "Login successful";
		} 
		else {
			return "Login failed: Invalid username or password";
		}
	}
	
}
