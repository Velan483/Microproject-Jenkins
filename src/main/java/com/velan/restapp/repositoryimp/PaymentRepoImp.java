package com.velan.restapp.repositoryimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.velan.restapp.model.Payment;
import com.velan.restapp.repository.PaymentRepo;

@Repository
@Transactional
public class PaymentRepoImp implements PaymentRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Payment payment) {
		em.persist(payment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findAllPayments() {
		String hql = "from Payment";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getIdList() {
		String hql="select payment_id from Payment";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Payment findById(int id) {
		return em.find(Payment.class, id);
	}

	@Override
	public void update(Payment payment) {
		em.merge(payment);
	}

	@Override
	public void delete(int id) {
		Payment payment = em.find(Payment.class, id);
		em.remove(payment);
	}

}
