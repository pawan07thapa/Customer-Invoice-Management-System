package com.p2s.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Customer;

@Service
public interface CustomerService {
	/**
	 * saves the customer to the repository
	 * 
	 * @param ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto addCustomer(Customer customer);

	/**
	 * fetches the customer from repository using id and returns it
	 * 
	 * @param customerId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto getCustomerById(int customerId);

	/**
	 * returns all the customers in a list
	 * 
	 * @return List<Customer>
	 * @author pawanthapa
	 */
	public List<Customer> getAllCustomer();

	/**
	 * updates the customer present in db
	 * 
	 * @param customer
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto updateCustomer(Customer customer);

	/**
	 * deletes the customer using id
	 * 
	 * @param id
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto deleteCustomerById(Integer id);

}
