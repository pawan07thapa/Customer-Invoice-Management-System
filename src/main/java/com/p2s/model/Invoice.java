package com.p2s.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data // for lombok
@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "invoice_date")
	private Timestamp invoiceDate;

	// changed from string type to Timestamp make these changes in DB too.
	@Column(name = "invoice_due_date")
	private Timestamp invoiceDueDate;

	@Column(name = "invoice_amount")
	private String invoiceAmount;

	@Column(name = "status")
	private String status;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_on")
	private Timestamp modifiedOn;

	@Transient
	private String invoicePendingAmount;

	/**
	 * Many to one used when we need to show all the information of this table using
	 * foreign key
	 * 
	 * @param name
	 *            = primary key of this table
	 * @param referencedColumn
	 *            = primary key of the referenced table
	 */

//	@ManyToOne
//	@JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
//	private Customer customer;

	/**
	 * @param mappedBy=
	 *            by what name is the primary key of this table saved on the other
	 *            table
	 */
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "invoiceId")
	@Transient
	private Set<Payment> listOfpayment;

}
