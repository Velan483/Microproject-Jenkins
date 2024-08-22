package com.velan.restapp.service;

import java.util.List;
import java.util.Optional;
import com.velan.restapp.model.Violator;

public interface ViolatorService {

	public void addViolator(Violator violator);
	Optional<Violator> authenticate(String email, String password);
	public Violator getViolator(int id);
	public List<Violator> getAllViolators();
	public void updateViolator(Violator violator);
	public void deleteViolator(int id);

}
