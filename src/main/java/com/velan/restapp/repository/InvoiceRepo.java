package com.velan.restapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.Invoice;

@Repository
public interface InvoiceRepo{

	public void add(Invoice invoice);
	public List<Invoice> findAllInvoices();
	public Invoice findById(int id);
	public void update(Invoice invoice);
	public void delete(int id);
	@Query("select invoice_id from Invoice")
	public List<Integer> getIdList();
	public List<Invoice> findByViolatorName(String name);
}
