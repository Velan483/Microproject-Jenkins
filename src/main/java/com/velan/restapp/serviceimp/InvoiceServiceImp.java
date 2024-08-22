package com.velan.restapp.serviceimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.restapp.model.Invoice;
import com.velan.restapp.repository.InvoiceRepo;
import com.velan.restapp.service.InvoiceService;

@Service
public class InvoiceServiceImp implements InvoiceService {

	@Autowired
	InvoiceRepo repo;

	@Override
	public void addInvoice(Invoice invoice) {
		repo.add(invoice);
	}

	@Override
	public Invoice getInvoice(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Invoice> getAllInvoices() {
		return repo.findAllInvoices();
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		repo.update(invoice);
	}

	@Override
	public void deleteInvoice(int id) {
		repo.delete(id);
	}

	public List<Integer> getAllId() {
		List<Integer> idList = repo.getIdList();
		return idList;
	}

	@Override
	public List<Invoice> getInvoiceByViolatorName(String name) {
		return repo.findByViolatorName(name);
	}

}
