package com.velan.restapp.serviceimp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.restapp.model.Violator;
import com.velan.restapp.repository.ViolatorRepo;
import com.velan.restapp.service.ViolatorService;

@Service
public class ViolatorServiceImp implements ViolatorService {

	@Autowired
	ViolatorRepo repo;

	@Override
	public void addViolator(Violator violator) {
		repo.add(violator);
	}
	
	@Override
    public Optional<Violator> authenticate(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }

	@Override
	public Violator getViolator(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Violator> getAllViolators() {
		return repo.findAllViolators();
	}

	@Override
	public void updateViolator(Violator violator) {
		repo.update(violator);
	}

	@Override
	public void deleteViolator(int id) {
		repo.delete(id);
	}

	public List<Integer> getAllId() {
		List<Integer> idList = repo.getIdList();
		return idList;
	}

}
