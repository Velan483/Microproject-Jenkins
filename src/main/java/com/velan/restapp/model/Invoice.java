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
@Table(name="Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="InvoiceID")
	private int invoice_id;
	@Column(name="Invoice Date")
	private Date invoice_Date ;
	@Column(name="Amount")
	private int amount;
	@Column(name="Due Date")
	private Date due_date;
	
	@OneToOne
    @JoinColumn(name = "ViolationID")
    private Violation violation;

	public Invoice() {
		super();
	}

	public Invoice(int invoice_id, Date invoice_Date, int amount, Date due_date, Violation violation) {
		super();
		this.invoice_id = invoice_id;
		this.invoice_Date = invoice_Date;
		this.amount = amount;
		this.due_date = due_date;
		this.violation = violation;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public Date getInvoice_Date() {
		return invoice_Date;
	}

	public void setInvoice_Date(Date invoice_Date) {
		this.invoice_Date = invoice_Date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Violation getViolation() {
		return violation;
	}

	public void setViolation(Violation violation) {
		this.violation = violation;
	}

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", invoice_Date=" + invoice_Date + ", amount=" + amount
				+ ", due_date=" + due_date + ", violation=" + violation + "]";
	}
	
}
