package com.velan.restapp.service;

import java.util.List;
import com.velan.restapp.model.Violation;

public interface ViolationService {

	public void addViolation(Violation violation);
	public Violation getViolation(int id);
	public List<Violation> getAllViolations();
	public void updateViolation(Violation violation);
	public void deleteViolation(int id);

}
