package com.velan.restapp.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PaymentID")
	private int payment_id;
	@Column(name="Payment Date")
	private Date payment_Date ;
	@Column(name="Amount")
	private int amount;
	@Column(name="Status")
	private String status;
	
	@OneToOne
    @JoinColumn(name = "InvoiceID")
    private Invoice invoice;

	public Payment() {
		super();
	}

	public Payment(int payment_id, Date payment_Date, int amount, String status, Invoice invoice) {
		super();
		this.payment_id = payment_id;
		this.payment_Date = payment_Date;
		this.amount = amount;
		this.status = status;
		this.invoice = invoice;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public Date getPayment_Date() {
		return payment_Date;
	}

	public void setPayment_Date(Date payment_Date) {
		this.payment_Date = payment_Date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", payment_Date=" + payment_Date + ", amount=" + amount
				+ ", status=" + status + ", invoice=" + invoice + "]";
	}

}
