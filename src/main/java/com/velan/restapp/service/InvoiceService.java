package com.velan.restapp.service;

import java.util.List;
import com.velan.restapp.model.Invoice;

public interface InvoiceService {

	public void addInvoice(Invoice invoice);
	public Invoice getInvoice(int id);
	public List<Invoice> getInvoiceByViolatorName(String name);
	public List<Invoice> getAllInvoices();
	public void updateInvoice(Invoice invoice);
	public void deleteInvoice(int id);

}
