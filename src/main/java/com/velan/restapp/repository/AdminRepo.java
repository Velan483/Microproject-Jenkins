package com.velan.restapp.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.Admin;

@Repository
public interface AdminRepo{
	
	public Optional<Admin> findByEmailAndPassword(String email, String password);
	
}

