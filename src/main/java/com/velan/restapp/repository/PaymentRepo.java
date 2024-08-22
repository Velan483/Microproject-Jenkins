package com.velan.restapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.Payment;

@Repository
public interface PaymentRepo{

	public void add(Payment payment);
	public List<Payment> findAllPayments();
	public Payment findById(int id);
	public void update(Payment payment);
	public void delete(int id);
	@Query("select payment_id from Payment")
	public List<Integer> getIdList();
}
