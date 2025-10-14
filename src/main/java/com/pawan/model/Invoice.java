package com.pawan.model;

import java.sql.Timestamp;
import java.util.List;


import jakarta.persistence.*;
import lombok.Data;


@Data // for lombok
@Entity
@Table(name = "invoice", schema = "cmis")
public class Invoice {
	// Add missing setters and getters for compatibility
	public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }
	public int getCustomerId() { return customerId; }
	public java.sql.Timestamp getInvoiceDate() { return invoiceDate; }
	public java.sql.Timestamp getInvoiceDueDate() { return invoiceDueDate; }
	public String getInvoiceAmount() { return invoiceAmount; }
	public int getId() { return id; }
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
	 * Many to one used when we need to show all the information of this table using foreign key
	 * @param name = primary key of this table
	 * @param referencedColumn = primary key of the referenced table
	 */
	


}
