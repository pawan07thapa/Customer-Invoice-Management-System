package com.p2s.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payment")
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
//	@ManyToOne
//	@JoinColumn(name="id",referencedColumnName="id", insertable=false , updatable=false)
//	private Invoice invoice;

}
