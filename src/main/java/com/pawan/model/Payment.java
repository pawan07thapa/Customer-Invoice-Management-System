package com.pawan.model;

import java.sql.Timestamp;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

import lombok.Data;


@Data
@Entity
@Table(name = "payment", schema = "cmis")
public class Payment {
	// Add missing setters and getters for compatibility
	public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }
	public int getCustomerId() { return customerId; }
	public int getInvoiceId() { return invoiceId; }
	public String getPaymentVoucher() { return paymentVoucher; }
	public int getId() { return id; }
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "invoice_id")
	private int invoiceId;

	@Column(name = "payment_voucher")
	private String paymentVoucher;

	@Column(name = "payment_amount")
	private int paymentAmount;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_on")
	private Timestamp modifiedOn;

}

