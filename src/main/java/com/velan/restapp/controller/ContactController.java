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
import com.velan.restapp.model.ContactPage;
import com.velan.restapp.serviceimp.ContactServiceImp;

@RestController
@RequestMapping("/contact")
@CrossOrigin("http://localhost:3000")
public class ContactController {

	@Autowired
	ContactServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public String insertContact(@RequestBody ContactPage contact) {
		String msg = "";
		try {
			service.addContact(contact);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}


	@GetMapping("/all")
	public List<ContactPage> getContactPage() {
		return service.getAllContactPages();
	}
	
	@DeleteMapping("{id}")
	public String deleteContactPageById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteContactPage(id);
			msg=SUCCESS;
		} 
		catch (Exception e) {
			msg=FAILURE;
		}
		return msg;
	}
 
}
