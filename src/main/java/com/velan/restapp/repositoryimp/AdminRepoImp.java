package com.velan.restapp.repositoryimp;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.Admin;
import com.velan.restapp.repository.AdminRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminRepoImp implements AdminRepo {

	@Autowired
	EntityManager em;
	
	@Override
	public Optional<Admin> findByEmailAndPassword(String email, String password) {
		TypedQuery<Admin> query = em.createQuery(
				"SELECT u FROM Admin u WHERE u.email = :email AND u.password = :password", Admin.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Admin admin = query.getResultStream().findFirst().orElse(null);
		return Optional.ofNullable(admin);
	}
	
}

