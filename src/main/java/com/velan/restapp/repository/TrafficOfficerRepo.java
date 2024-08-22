package com.velan.restapp.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.TrafficOfficer;

@Repository
public interface TrafficOfficerRepo{

	public void add(TrafficOfficer officer);
	public Optional<TrafficOfficer> findByEmailAndPassword(String email, String password);
	public List<TrafficOfficer> findAllTrafficOfficers();
	public TrafficOfficer findById(int id);
	public void update(TrafficOfficer officer);
	public void delete(int id);
	@Query("select officer_id from TrafficOfficer")
	public List<Integer> getIdList();
}
