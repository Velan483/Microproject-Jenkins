package com.velan.restapp.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.velan.restapp.model.TrafficOfficer;
import com.velan.restapp.serviceimp.TrafficOfficerServiceImp;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/officer")
@CrossOrigin("http://localhost:3000")
public class TrafficOfficerController {

	@Autowired
	TrafficOfficerServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public String insertTrafficOfficer(@RequestBody TrafficOfficer officer) {
		String msg = "";
		try {
			service.addTrafficOfficer(officer);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@PostMapping("/login")
	public String TrafficOfficerlogin(@RequestBody TrafficOfficer officer) {
		Optional<TrafficOfficer> trafficOfficer = service.authenticate(officer.getEmail(), officer.getPassword());
		if (trafficOfficer.isPresent()) {
			return "Login successful";
		} 
		else {
			return "Login failed: Invalid username or password";
		}
	}

	@GetMapping("{id}")
	public TrafficOfficer getTrafficOfficerById(@PathVariable("id") int id) {
		return service.getTrafficOfficer(id);
	}

	@GetMapping("/all")
	public List<TrafficOfficer> getTrafficOfficers() {
		return service.getAllTrafficOfficers();
	}
	
	@PutMapping()
	public String updateTrafficOfficer(@RequestBody TrafficOfficer officer) {
		String msg = "";

		try {
			service.updateTrafficOfficer(officer);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteTrafficOfficerById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteTrafficOfficer(id);
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
