package com.velan.restapp.serviceimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.restapp.model.Violation;
import com.velan.restapp.repository.ViolationRepo;
import com.velan.restapp.service.ViolationService;

@Service
public class ViolationServiceImp implements ViolationService {

	@Autowired
	ViolationRepo repo;

	@Override
	public void addViolation(Violation violation) {
		repo.add(violation);
	}

	@Override
	public Violation getViolation(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Violation> getAllViolations() {
		return repo.findAllViolations();
	}

	@Override
	public void updateViolation(Violation violation) {
		repo.update(violation);
	}

	@Override
	public void deleteViolation(int id) {
		repo.delete(id);
	}

	public List<Integer> getAllId() {
		List<Integer> idList = repo.getIdList();
		return idList;
	}

}
