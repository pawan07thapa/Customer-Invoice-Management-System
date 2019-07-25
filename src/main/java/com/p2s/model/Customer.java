package com.p2s.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "company")
	private String company;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_on")
	private Timestamp modifiedOn;
	
	/**
	 * @param mappedBy= by what name is the primary key of this table saved on the other table
	 */
	@OneToMany(mappedBy="customerId")
	private List<Invoice> listOfInvoice;

}
