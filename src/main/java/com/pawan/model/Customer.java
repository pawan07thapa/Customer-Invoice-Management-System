	package com.pawan.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer", schema = "cmis")
public class Customer {
	// Add missing setters and getters for compatibility
	public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getEmail() { return email; }
	public String getAddress() { return address; }
	public String getCompany() { return company; }
	public String getPhoneNumber() { return phoneNumber; }
	public int getId() { return id; }
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


	// Explicit setters for all fields
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setEmail(String email) { this.email = email; }
	public void setAddress(String address) { this.address = address; }
	public void setCompany(String company) { this.company = company; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
