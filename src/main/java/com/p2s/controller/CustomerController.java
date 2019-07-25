package com.p2s.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Customer;

@Controller
public interface CustomerController {
	/**
	 * RESPONSE BODY IS USED FOR POST AND PUT MAPPING REQUEST BODY IS USED FOR GET
	 * MAPPING
	 */

	/**
	 * This method directs the customer towards the addCustomer form
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer();

	/**
	 * Saving the Customer after the form has been filled
	 * 
	 * @param Customer
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@PostMapping("/customer")
	@ResponseBody
	public ResponseEntity<ResponseDto> saveCustomer(@RequestBody Customer customer);

	/**
	 * saves the customer in db
	 * 
	 * @param id
	 * @return ResponseBody<ResponseDto>
	 * @author pawanthapa
	 */
	@GetMapping("/customer/{id}")
	@ResponseBody
	public ResponseEntity<ResponseDto> getCustomerById(@PathVariable("id") int id);

	/**
	 * fetches the customer using customerId , adds it to ModelAndView Object. Used
	 * to show detail of an individual Customer
	 * 
	 * @param id
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/showCustomer")
	public ModelAndView showCustomer(@RequestParam int customerId);

	/**
	 * fetches all the customers and returns them in a list
	 * 
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@GetMapping("/customers")
	public ResponseEntity<ResponseDto> getAllCustomers();

	/**
	 * Updates the information about customer
	 * 
	 * @param customer
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@PutMapping("/customer")
	@ResponseBody
	public ResponseEntity<ResponseDto> updateCustomer(@RequestBody Customer customer);

	/**
	 * deletes custmer using CustomerId
	 * 
	 * @param id
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@DeleteMapping("/customer/{id}")
	@ResponseBody
	public ResponseEntity<ResponseDto> deleteCustomerById(@PathVariable("id") int id);

	/**
	 * Adds all the customers to ModelAndView object and displays them in
	 * Customers.jsp
	 * 
	 * @param Customer
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/showAllCustomers")
	public ModelAndView showAllCustomers();

}
