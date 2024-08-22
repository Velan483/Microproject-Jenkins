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
import com.velan.restapp.model.Invoice;
import com.velan.restapp.serviceimp.InvoiceServiceImp;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/invoice")
@CrossOrigin("http://localhost:3000")
public class Invoicecontroller {

	@Autowired
	InvoiceServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public String insertInvoice(@RequestBody Invoice invoice) {
		String msg = "";
		try {
			service.addInvoice(invoice);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	@GetMapping("{id}")
	public Invoice getInvoiceById(@PathVariable("id") int id) {
		return service.getInvoice(id);
	}
	
	@GetMapping("/name/{name}")
    public List<Invoice> getInvoiceByName(@PathVariable("name") String name) {
        return service.getInvoiceByViolatorName(name);
    }

	@GetMapping("/all")
	public List<Invoice> getInvoices() {
		return service.getAllInvoices();
	}
	
	@PutMapping()
	public String updateInvoice(@RequestBody Invoice invoice) {
		String msg = "";

		try {
			service.updateInvoice(invoice);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteInvoiceById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteInvoice(id);
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
