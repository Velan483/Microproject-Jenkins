package com.velan.restapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model. Violator;

@Repository
public interface ViolatorRepo{

	public void add( Violator violator);
	public Optional<Violator> findByEmailAndPassword(String email, String password);
	public List< Violator> findAllViolators();
	public  Violator findById(int id);
	public void update( Violator  violator);
	public void delete(int id);
	@Query("select violator_id from  Violator")
	public List<Integer> getIdList();
}
