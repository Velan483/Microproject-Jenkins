package com.velan.restapp.serviceimp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.restapp.model.TrafficOfficer;
import com.velan.restapp.repository.TrafficOfficerRepo;
import com.velan.restapp.service.TrafficOfficerService;

@Service
public class TrafficOfficerServiceImp implements TrafficOfficerService {

	@Autowired
	TrafficOfficerRepo repo;

	@Override
	public void addTrafficOfficer(TrafficOfficer officer) {
		repo.add(officer);
	}

	@Override
    public Optional<TrafficOfficer> authenticate(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }
	
	@Override
	public TrafficOfficer getTrafficOfficer(int id) {
		return repo.findById(id);
	}

	@Override
	public List<TrafficOfficer> getAllTrafficOfficers() {
		return repo.findAllTrafficOfficers();
	}

	@Override
	public void updateTrafficOfficer(TrafficOfficer officer) {
		repo.update(officer);
	}

	@Override
	public void deleteTrafficOfficer(int id) {
		repo.delete(id);
	}

	public List<Integer> getAllId() {
		List<Integer> idList = repo.getIdList();
		return idList;
	}

}
