package com.velan.restapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.velan.restapp.service.EmailService;
import com.velan.restapp.model.Violator;
import com.velan.restapp.serviceimp.ViolatorServiceImp;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/violator")
@CrossOrigin("http://localhost:3000")
public class ViolatorController {

	@Autowired
	ViolatorServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public String insertViolator(@RequestBody Violator violator) {
		String msg = "";
		try {
			service.addViolator(violator);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@PostMapping("/login")
	public String Violatorlogin(@RequestBody Violator violator) {
		Optional<Violator> violatoruser = service.authenticate(violator.getEmail(), violator.getPassword());
		if (violatoruser.isPresent()) {
			return "Login successful";
		} 
		else {
			return "Login failed: Invalid username or password";
		}
	}

	@GetMapping("{id}")
	public Violator getViolatorById(@PathVariable("id") int id) {
		return service.getViolator(id);
	}

	@GetMapping("/all")
	public List<Violator> getViolators() {
		return service.getAllViolators();
	}
	
	@PutMapping()
	public String updateViolator(@RequestBody Violator violator) {
		String msg = "";

		try {
			service.updateViolator(violator);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteViolatorById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteViolator(id);
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
	
	@Autowired
    private EmailService emailService;	

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam(required = false) MultipartFile attachment
    ) {
        try {
            emailService.sendEmail(from,to, subject, body, attachment);
            return ResponseEntity.ok("Email sent successfully");
        } catch (MessagingException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
        }
    }

 
}
