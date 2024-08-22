package com.velan.restapp.service;

import java.util.List;
import com.velan.restapp.model.Payment;

public interface PaymentService {

	public void addPayment(Payment payment);
	public Payment getPayment(int id);
	public List<Payment> getAllPayments();
	public void updatePayment(Payment Payment);
	public void deletePayment(int id);

}
