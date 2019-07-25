package com.p2s.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Customer;
import com.p2s.service.CustomerService;
import com.p2s.utils.Constant;

@Controller
public class CustomerControllerImpl implements CustomerController {

	/**
	 * Logger for debugging
	 */
	private static Logger logger = Logger.getLogger(CustomerControllerImpl.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * This method directs the customer towards the addCustomer form
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView addCustomer() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addCustomer.jsp");
		logger.info("Directed to addCustomer form");
		return mv;
	}

	/**
	 * Saving the Customer after the form has been filled
	 * 
	 * @param customer
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@Override
	@ResponseBody
	public ResponseEntity<ResponseDto> saveCustomer(@RequestBody Customer customer) {
		try {
			logger.info("Saving customer started.");
			ResponseDto response = customerService.addCustomer(customer);
			logger.info("Saving customer successfully.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Saving customer failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("Add customer failed." + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	/**
	 * fetches customer using customerId
	 * 
	 * @param customerId
	 * @return ResponseBody<ResponseDto>
	 * @author pawanthapa
	 */
	@Override
	public ResponseEntity<ResponseDto> getCustomerById(@PathVariable("id") int customerId) {
		try {
			logger.info("Fetching customer started. ");
			ResponseDto response = customerService.getCustomerById(customerId);
			logger.info("Fetching customer completed. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Fetching customer failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("Customer fetching failed. " + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * fetches the customer using customerId , adds it to ModelAndView Object. Used
	 * to show detail of an individual Customer
	 * 
	 * @param customerId
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView showCustomer(@RequestParam int customerId) {
		logger.info("Adding customer data to model. ");
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", customerService.getCustomerById(customerId).getData());
		mv.setViewName("customerDetail.jsp");
		logger.info("Directed to customerDetail.jsp. ");
		return mv;
	}

	/**
	 * 
	 * fetches all the customers and returns them in a list
	 * 
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa -
	 */
	@Override
	public ResponseEntity<ResponseDto> getAllCustomers() {
		try {
			logger.info("Fetching list of customers started. ");
			List<Customer> listOfCustomers = customerService.getAllCustomer();
			logger.info("Fetching list of customers completed. ");
			return new ResponseEntity<>(new ResponseDto("Fetching customers successful. ", 0, listOfCustomers.size(),
					listOfCustomers, Constant.SUCCESS), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Fetching list of customer failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("Fetching customers failed." + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Updates the information about customer
	 * 
	 * @param Customer
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@Override
	@ResponseBody
	public ResponseEntity<ResponseDto> updateCustomer(@RequestBody Customer customer) {
		ResponseDto response = null;
		try {
			logger.info("Customer updation started. ");
			response = customerService.updateCustomer(customer);
			if(response.getStatus()==Constant.SUCCESS) {
			logger.info("Customer updated. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				logger.info("Customer could not be updated. ");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.info("Updation failed " + e.getMessage());
			return new ResponseEntity<>(new ResponseDto("Customer updation failed. ", 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * deletes custmer using CustomerId
	 * 
	 * @param id
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@Override
	@ResponseBody
	public ResponseEntity<ResponseDto> deleteCustomerById(@PathVariable("id") int id) {
		try {
			logger.info("Deleting customer started. ");
			ResponseDto response = customerService.deleteCustomerById(id);
			logger.info("Customer deleted. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Deleting customer failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("Customer Deletion Failed. " + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Adds all the customers to ModelAndView object and displays them in
	 * Customers.jsp
	 * 
	 * @param Customer
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView showAllCustomers() {
		logger.info("Adding all customers data to model. ");
		ModelAndView mv = new ModelAndView();
		mv.addObject("listOfCustomers", customerService.getAllCustomer());
		mv.setViewName("customers.jsp");
		logger.info("Customers data added. ");
		return mv;
	}
}
