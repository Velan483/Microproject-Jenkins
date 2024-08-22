package com.velan.restapp.service;

import java.util.Optional;
import com.velan.restapp.model.Admin;


public interface AdminService {

	Optional<Admin> authenticate(String email, String password);
	
}

