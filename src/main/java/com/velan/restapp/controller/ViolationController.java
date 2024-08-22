package com.velan.restapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.velan.restapp.model.Violation;
import com.velan.restapp.serviceimp.ViolationServiceImp;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/violation")
@CrossOrigin("http://localhost:3000")
public class ViolationController {

	@Autowired
	ViolationServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public String insertViolation(@RequestBody Violation violation) {
		String msg = "";
		try {
			service.addViolation(violation);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	@GetMapping("{id}")
	public Violation getViolationById(@PathVariable("id") int id) {
		return service.getViolation(id);
	}

	@GetMapping("/all")
	public List<Violation> getViolations() {
		return service.getAllViolations();
	}
	
	@PutMapping()
	public String updateViolation(@RequestBody Violation violation) {
		String msg = "";

		try {
			service.updateViolation(violation);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteViolationById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteViolation(id);
			msg=SUCCESS;
		} 
		catch (Exception e) {
			msg=FAILURE;
		}
		return msg;
	}
	
	@GetMapping("/idlist")
	public List<Integer> getIdList() {
		return service.getAllId();
	}
 
}
