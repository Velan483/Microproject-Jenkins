package com.velan.restapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.Violation;

@Repository
public interface ViolationRepo{

	public void add(Violation violation);
	public List<Violation> findAllViolations();
	public Violation findById(int id);
	public void update(Violation violation);
	public void delete(int id);
	@Query("select violation_id from Violation")
	public List<Integer> getIdList();
}
