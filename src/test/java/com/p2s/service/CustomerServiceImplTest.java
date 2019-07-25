package com.p2s.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.p2s.config.WebConfig;
import com.p2s.dto.ResponseDto;
import com.p2s.model.Customer;
import com.p2s.repository.CustomerRepository;
import com.p2s.utils.Constant;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class })
public class CustomerServiceImplTest {
	// the class in which you are injecting mocks cannot be mocked
	@InjectMocks
	private CustomerServiceImpl custService;

	// creates a mock reference to custRepo
	@Mock
	private CustomerRepository custRepo;

	@Before
	public void init() {
		Customer customer = new Customer();
		Mockito.when(custRepo.findOne(1)).thenReturn(customer);
	}

	/**
	 * tests addCustomer method with valid data
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testAddCustomer_validData() {
		Customer customer = new Customer();
		customer.setFirstName("Pawan");
		customer.setLastName("Thapa");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress("delhi");
		customer.setCompany("p2sme");
		customer.setPhoneNumber("9319042883");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");
		Mockito.when(custRepo.save(customer)).thenReturn(customer);

		ResponseDto response = custService.addCustomer(customer);
		Assert.assertEquals("Checking reponse message ", "Customer added successfully. ", response.getMessage());
		Assert.assertEquals("Checking status ", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());

	}

	/**
	 * This method checks addCustomer method when all fields are empty
	 *
	 * @author pawanthapa
	 */
	@Test
	public void testAddCustomer_invalidDataAllEmpty() {
		Customer customer = new Customer();
		customer.setFirstName("");
		customer.setLastName("");
		customer.setEmail("");
		customer.setAddress("");
		customer.setCompany("");
		customer.setPhoneNumber("");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");

		Mockito.when(custRepo.save(customer)).thenReturn(customer);
		ResponseDto response = custService.addCustomer(customer);
		String message = "FirstName cannot be null or empty, " + "LastName cannot be null or empty, "
				+ "Email cannot be null or empty, " + "Address cannot be null or empty, "
				+ "Comapny name cannot be null or empty, " + "Phone Number cannot be null or empty";

		Assert.assertEquals("Checking message", message, response.getMessage());
		Assert.assertEquals("Checking status", Constant.BAD_REQUEST, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());

	}

	/**
	 * This method checks addCustomer method when all fields are null
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testAddCustomer_invalidDataAllNull() {
		Customer customer = new Customer();
		customer.setFirstName(null);
		customer.setLastName(null);
		customer.setEmail(null);
		customer.setAddress(null);
		customer.setCompany(null);
		customer.setPhoneNumber(null);
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");
		String message = "FirstName cannot be null or empty, " + "LastName cannot be null or empty, "
				+ "Email cannot be null or empty, " + "Address cannot be null or empty, "
				+ "Comapny name cannot be null or empty, " + "Phone Number cannot be null or empty";

		Mockito.when(custRepo.save(customer)).thenReturn(customer);
		ResponseDto response = custService.addCustomer(customer);
		Assert.assertEquals("Checking message", message, response.getMessage());
		Assert.assertEquals("Checking status", Constant.BAD_REQUEST, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
	}

	/**
	 * This method tests addCustomer method when fields are valid,empty and null
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testAddCustomer_invalidDataEmptyAndNull() {
		Customer customer = new Customer();
		customer.setFirstName("Pawan");
		customer.setLastName("");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress(null);
		customer.setCompany("");
		customer.setPhoneNumber("");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");
		String message = "LastName cannot be null or empty, " + "Address cannot be null or empty, "
				+ "Comapny name cannot be null or empty, " + "Phone Number cannot be null or empty";

		//
		Mockito.when(custRepo.save(customer)).thenReturn(customer);
		ResponseDto response = custService.addCustomer(customer);
		Assert.assertEquals("Checking message", message, response.getMessage());
		Assert.assertEquals("Checking status", Constant.BAD_REQUEST, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
	}

	/**
	 * tests getCustomerById method when the id is valid
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testgetCustomerById_validId() {
		// Create object
		Customer customer = new Customer();
		int id = 221;
		customer.setId(id);
		customer.setFirstName("Pawan");
		customer.setLastName("Thapa");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress("delhi");
		customer.setCompany("p2sme");
		customer.setPhoneNumber("9319042883");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");

		// method
		Mockito.when(custRepo.findOne(id)).thenReturn(customer);
		// Get response using the orignal function
		ResponseDto response = custService.getCustomerById(id);

		// assert response
		Assert.assertEquals("Checking message", "Customer fetched successfully. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
		return;
	}

	/**
	 * tests getCustomerById method when the id is not valid
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testgetCustomerById_invalidId() {
		// Create object
		Customer customer = new Customer();
		int id = 221;
		customer.setId(id);
		customer.setFirstName("Pawan");
		customer.setLastName("Thapa");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress("delhi");
		customer.setCompany("p2sme");
		customer.setPhoneNumber("9319042883");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");

		// method used in implementation
		Mockito.when(custRepo.findOne(id)).thenReturn(customer);
		// Get response using the orignal function
		ResponseDto response = custService.getCustomerById(222);

		// assert response
		Assert.assertEquals("Checking message", "Customer fetch failed. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.FAILED, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
		return;
	}

	// no invalid test case present
	/**
	 * tests getAllCustomer method
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testgetAllCustomer_valid() {
		List<Customer> custList = new ArrayList<>();
		Customer customer = new Customer();
		int id = 221;
		customer.setId(id);
		customer.setFirstName("Pawan");
		customer.setLastName("Thapa");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress("delhi");
		customer.setCompany("p2sme");
		customer.setPhoneNumber("9319042883");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");
		custList.add(customer);
		Mockito.when(custRepo.findAll()).thenReturn(custList);
		Assert.assertEquals(1, custService.getAllCustomer().size());
	}

	/**
	 * tests updateCustomer method when the id is valid
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testupdateCustomer_valid() {
		Customer customerInDB = new Customer();
		customerInDB.setId(221);
		customerInDB.setFirstName("Amrit");
		customerInDB.setAddress("Allahabad");
		Mockito.when(custRepo.findOne(221)).thenReturn(customerInDB);
		Mockito.when(custRepo.save(customerInDB)).thenReturn(customerInDB);

		Customer customer = new Customer();
		customer.setId(221);
		customer.setFirstName("Pawan");
		customer.setLastName("Thapa");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress("delhi");
		customer.setCompany("p2sme");
		customer.setPhoneNumber("9319042883");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");
		ResponseDto response = custService.updateCustomer(customer);

		// assert response
		Assert.assertEquals("Checking message", "Updated successfully. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
		return;
	}

	/**
	 * tests getCustomerById method when the id is not valid(i.e. customer to be
	 * updated is not present in the DB)
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testupdateCustomer_invalid() {
		// Create object
		Customer customer = new Customer();
		int id = 221;
		customer.setId(id);
		customer.setFirstName("Pawan");
		customer.setLastName("Thapa");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress("delhi");
		customer.setCompany("p2sme");
		customer.setPhoneNumber("9319042883");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");

		// giving invalid id
		Mockito.when(custRepo.findOne(300)).thenReturn(customer);

		// Update customer values

		customer.setFirstName("Amrit");
		customer.setAddress("Allahabad");
		// not able to call this method because it is private
		// Mockito.when(custService.setCustomerIfValuesUpdated(customerInDB,
		// customer)).thenReturn(true);

		Mockito.when(custRepo.save(customer)).thenReturn(customer);

		// Get response using the orignal function
		ResponseDto response = custService.updateCustomer(customer);

		// assert response
		Assert.assertEquals("Checking message", "Customer does not exist", response.getMessage());
		Assert.assertEquals("Checking status", Constant.FAILED, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
		return;
	}

	/**
	 * tests deleteCustomerById method when id is valid(customer is present in DB)
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testdeleteCustomerById_validId() {
		// Create object
		Customer customer = new Customer();
		int id = 221;
		customer.setId(id);
		customer.setFirstName("Pawan");
		customer.setLastName("Thapa");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress("delhi");
		customer.setCompany("p2sme");
		customer.setPhoneNumber("9319042883");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");

		// method used in implementation
		Mockito.when(custRepo.findOne(id)).thenReturn(customer);
		// Get response using the orignal function
		ResponseDto response = custService.deleteCustomerById(221);

		// assert response
		Assert.assertEquals("Checking message", "Customer deleted successfully. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
		return;
	}

	/**
	 * tests deleteCustomerById method when id is invalid(customer is not present in
	 * DB)
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testdeleteCustomerById_invalidId() {
		// Create object
		Customer customer = new Customer();
		int id = 221;
		customer.setId(id);
		customer.setFirstName("Pawan");
		customer.setLastName("Thapa");
		customer.setEmail("pawan@gmail.com");
		customer.setAddress("delhi");
		customer.setCompany("p2sme");
		customer.setPhoneNumber("9319042883");
		customer.setCreatedBy("Pawan Thapa");
		customer.setModifiedBy("Pawan Thapa");

		// method used in implementation
		Mockito.when(custRepo.findOne(id)).thenReturn(customer);
		// Get response using the orignal function
		ResponseDto response = custService.deleteCustomerById(300);

		// assert response
		Assert.assertEquals("Checking message", "Customer does not exist. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.FAILED, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
		return;
	}
}
