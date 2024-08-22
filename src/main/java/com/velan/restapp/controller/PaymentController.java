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
import com.velan.restapp.model.Payment;
import com.velan.restapp.serviceimp.PaymentServiceImp;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:3000")
public class PaymentController {

	@Autowired
	PaymentServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public String insertPayment(@RequestBody Payment payment) {
		String msg = "";
		try {
			service.addPayment(payment);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	@GetMapping("{id}")
	public Payment getPaymentById(@PathVariable("id") int id) {
		return service.getPayment(id);
	}

	@GetMapping("/all")
	public List<Payment> getPayments() {
		return service.getAllPayments();
	}
	
	@PutMapping()
	public String updatePayment(@RequestBody Payment payment) {
		String msg = "";

		try {
			service.updatePayment(payment);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deletePaymentById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deletePayment(id);
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
