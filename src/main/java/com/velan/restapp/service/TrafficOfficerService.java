package com.velan.restapp.service;

import java.util.List;
import java.util.Optional;
import com.velan.restapp.model.TrafficOfficer;

public interface TrafficOfficerService {

	public void addTrafficOfficer(TrafficOfficer officer);
	Optional<TrafficOfficer> authenticate(String email, String password);
	public TrafficOfficer getTrafficOfficer(int id);
	public List<TrafficOfficer> getAllTrafficOfficers();
	public void updateTrafficOfficer(TrafficOfficer officer);
	public void deleteTrafficOfficer(int id);

}
