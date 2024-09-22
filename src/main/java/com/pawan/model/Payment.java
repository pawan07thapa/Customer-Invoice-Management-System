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

	/**
	 * Many to one used when we need to show all the information of this table using foreign key
	 * @param name = primary key of this table
	 * @param referencedColumn = primary key of the referenced table
	 */
	@ManyToOne
	@JoinColumn(name="id",referencedColumnName="id", insertable=false , updatable=false)
	private Invoice invoice;

}
