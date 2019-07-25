package com.p2s.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Customer;
import com.p2s.repository.CustomerRepository;
import com.p2s.utils.Constant;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository repo;

	/**
	 * saves the customer to the repository
	 * 
	 * @param ResponseDto
	 * @author pawanthapa
	 */
	@Override
	public ResponseDto addCustomer(Customer customer) {
		logger.info("Saving customer started. ");
		String message = validateCustomer(customer);
		if (!message.isEmpty()) {
			return new ResponseDto(message, 0, 0, null, Constant.BAD_REQUEST);
		} else {
			customer.setCreatedBy("Pawan Thapa");
			customer.setModifiedBy("Pawan Thapa");
			repo.save(customer);
			logger.info("Customer saved");
			return new ResponseDto("Customer added successfully. ", 0, 1, customer, Constant.SUCCESS);
		}
	}

	private String validateCustomer(Customer customer) {
		String message = "";
		if (customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
			message = message + "FirstName cannot be null or empty, ";
		}
		if (customer.getLastName() == null || customer.getLastName().isEmpty()) {
			message = message + "LastName cannot be null or empty, ";
		}
		if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
			message = message + "Email cannot be null or empty, ";
		}
		if (customer.getAddress() == null || customer.getAddress().isEmpty()) {
			message = message + "Address cannot be null or empty, ";
		}
		if (customer.getCompany() == null || customer.getCompany().isEmpty()) {
			message = message + "Comapny name cannot be null or empty, ";
		}
		if (customer.getPhoneNumber() == null || customer.getPhoneNumber().isEmpty()) {
			message = message + "Phone Number cannot be null or empty, ";
		}
		if (!message.isEmpty()) {
			message = message.substring(0, message.length() - 2);
		}
		return message;
	}

	/**
	 * fetches the customer from repository using id and returns it
	 * 
	 * @param customerId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	@Override
	public ResponseDto getCustomerById(int customerId) {
		logger.info("Fetching customer using with id " + customerId);
		Customer customer = repo.findOne(customerId);
		if (customer != null) {
			return new ResponseDto("Customer fetched successfully. ", 0, 1, customer, Constant.SUCCESS);
		} else {
			return new ResponseDto("Customer fetch failed. ", 0, 0, null, Constant.FAILED);
		}
	}

	/**
	 * returns all the customers in a list
	 * 
	 * @return List<Customer>
	 * @author pawanthapa
	 */
	@Override
	public List<Customer> getAllCustomer() {
		logger.info("fetching customer list started");
		List<Customer> listOfCustomers = repo.findAll();
		logger.info("fetching customer list finished");
		return listOfCustomers;
	}

	/**
	 * updates the customer present in db . If true if returned from
	 * setCustomerIfValuesUpdated() that means fields have been edited, we then save
	 * this in repository, no need to save it in repository
	 * 
	 * @param customer
	 * @return ResponseDto
	 * @author pawanthapa
	 */

	@Override
	public ResponseDto updateCustomer(Customer customer) {
		logger.info("Fetching customer to be updated");
		Customer customerInDB = repo.findOne(customer.getId());

		if (customerInDB != null) {
			logger.info("Customer fetched successfully");
			logger.info("Checking if customer values are edited. ");
			String message = validateCustomer(customer);
			//if message is empty means customer is validated
			if (message.isEmpty()) {
				boolean isUpdated = setCustomerIfValuesUpdated(customerInDB, customer);
				if (isUpdated) {
					logger.info("Customer values are edited ");
					repo.save(customerInDB);
					logger.info("Customer values are updated in DB  ");
					return new ResponseDto("Updated successfully. ", 0, 1, customerInDB, Constant.SUCCESS);
				} else {
					// No fields updated
					logger.info("Customer values are not edited ");
					return new ResponseDto("No fields updated. ", 0, 1, null, Constant.BAD_REQUEST);
				}
			} else {
				// message is not empty , means values are edited and made null in table
				return new ResponseDto(message, 0, 0, null, Constant.BAD_REQUEST);
			}
		} else {
			// Customer does not exist.
			logger.info("Customer does not exist. ");
			return new ResponseDto("Customer does not exist", 0, 0, null, Constant.FAILED);

		}
	}

	/**
	 * checks if Customer fields values are edited , and only make changes to those
	 * fields which are edited . If any of the fields is edited returns true else
	 * returns false
	 * 
	 * @param customerInDB
	 * @param customer
	 * @return boolean
	 * @author pawanthapa
	 */
	public boolean setCustomerIfValuesUpdated(Customer customerInDB, Customer customer) {
		boolean isUpdate = false;
		if (customer.getFirstName() != null && !customer.getFirstName().isEmpty()
				&& !customer.getFirstName().equals(customerInDB.getFirstName())) {
			logger.info("Customer first name updated. ");
			customerInDB.setFirstName(customer.getFirstName());
			isUpdate = true;
		}
		if (customer.getLastName() != null && !customer.getLastName().isEmpty()
				&& !customer.getLastName().equals(customerInDB.getLastName())) {
			logger.info("Customer last name updated. ");
			customerInDB.setLastName(customer.getLastName());
			isUpdate = true;
		}
		if (customer.getEmail() != null && !customer.getEmail().isEmpty()
				&& !customer.getEmail().equals(customerInDB.getEmail())) {
			logger.info("Customer email updated. ");
			customerInDB.setEmail(customer.getEmail());
			isUpdate = true;
		}
		if (customer.getAddress() != null && !customer.getAddress().isEmpty()
				&& !customer.getAddress().equals(customerInDB.getAddress())) {
			logger.info("Customer Address updated. ");
			customerInDB.setAddress(customer.getAddress());
			isUpdate = true;
		}
		if (customer.getCompany() != null && !customer.getCompany().isEmpty()
				&& !customer.getCompany().equals(customerInDB.getCompany())) {
			logger.info("Customer company name updated. ");
			customerInDB.setCompany(customer.getCompany());
			isUpdate = true;
		}
		if (customer.getPhoneNumber() != null && !customer.getPhoneNumber().isEmpty()
				&& !customer.getPhoneNumber().equals(customerInDB.getPhoneNumber())) {
			logger.info("Customer phone number updated. ");
			customerInDB.setPhoneNumber(customer.getPhoneNumber());
			isUpdate = true;
		}
		return isUpdate;
	}

	/**
	 * deletes the customer using id
	 * 
	 * @param id
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	@Override
	public ResponseDto deleteCustomerById(Integer id) {
		logger.info("Deletion with id " + id + " started");
		if (repo.findOne(id) == null) {
			logger.info("Customer does  not exist. ");
			return new ResponseDto("Customer does not exist. ", 0, 0, null, Constant.FAILED);
		} else {
			logger.info("Customer found. ");
			repo.delete(id);
			logger.info("Deletion of id " + id + " done");
			return new ResponseDto("Customer deleted successfully. ", 0, 0, null, Constant.SUCCESS);
		}

	}
}
