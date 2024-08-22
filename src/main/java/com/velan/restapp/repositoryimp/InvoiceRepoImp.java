package com.velan.restapp.repositoryimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import com.velan.restapp.model.Invoice;
import com.velan.restapp.repository.InvoiceRepo;

@Repository
@Transactional
public class InvoiceRepoImp implements InvoiceRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Invoice invoice) {
		em.persist(invoice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> findAllInvoices() {
		String hql = "from Invoice";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getIdList() {
		String hql="select invoice_id from Invoice";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Invoice findById(int id) {
		return em.find(Invoice.class, id);
	}

	@Override
	public List<Invoice> findByViolatorName(String name) {
	    String jpql = "select i from Invoice i join i.violation v join v.violator vr where vr.name = :name";
	    TypedQuery<Invoice> query = em.createQuery(jpql, Invoice.class);
	    query.setParameter("name", name);
	    return query.getResultList();
	}
	
	@Override
	public void update(Invoice invoice) {
		em.merge(invoice);
	}

	@Override
	public void delete(int id) {
		Invoice invoice = em.find(Invoice.class, id);
		em.remove(invoice);
	}

}
