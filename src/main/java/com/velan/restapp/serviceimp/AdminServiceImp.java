package com.velan.restapp.serviceimp;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.restapp.model.Admin;
import com.velan.restapp.repository.AdminRepo;
import com.velan.restapp.service.AdminService;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	AdminRepo repo;

	@Override
    public Optional<Admin> authenticate(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }

}
