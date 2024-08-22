package com.velan.restapp.serviceimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.restapp.model.Payment;
import com.velan.restapp.repository.PaymentRepo;
import com.velan.restapp.service.PaymentService;

@Service
public class PaymentServiceImp implements PaymentService {

	@Autowired
	PaymentRepo repo;

	@Override
	public void addPayment(Payment payment) {
		repo.add(payment);
	}

	@Override
	public Payment getPayment(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Payment> getAllPayments() {
		return repo.findAllPayments();
	}

	@Override
	public void updatePayment(Payment payment) {
		repo.update(payment);
	}

	@Override
	public void deletePayment(int id) {
		repo.delete(id);
	}

	public List<Integer> getAllId() {
		List<Integer> idList = repo.getIdList();
		return idList;
	}

}
