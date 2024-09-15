//package com.pawan.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//
//import com.pawan.dto.ResponseDto;
//import com.pawan.model.Customer;
//import com.pawan.repository.CustomerRepository;
//import com.pawan.utils.Constant;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(MockitoExtension.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = { WebAppConfiguration.class })
//
//public class CustomerServiceImplTest {
//
//	// the class in which you are injecting mocks cannot be mocked
//	@InjectMocks
//	private CustomerService custService;
//
//	// creates a mock reference to custRepo
//	@Mock
//	private CustomerRepository custRepo;
//
//	@BeforeEach
//	public void init() {
//		Customer customer = new Customer();
//		Mockito.when(custRepo.findById(1)).thenReturn(Optional.of(customer));
//	}
//
//	/**
//	 * Tests addCustomer method with valid data.
//	 *
//	 * @author pawanthapa
//	 **/
//	@Test
//	public void testAddCustomer_validData() {
//		Customer customer = new Customer();
//		customer.setFirstName("Pawan");
//		customer.setLastName("Thapa");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress("delhi");
//		customer.setCompany("p2sme");
//		customer.setPhoneNumber("9319042883");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//		Mockito.when(custRepo.save(customer)).thenReturn(customer);
//
//		ResponseDto response = custService.addCustomer(customer);
//		assertEquals("Customer added successfully. ", response.getMessage(), "Checking message");
//		assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
//		assertEquals("Pawan Thapa", customer.getModifiedBy(), "Checking modified by");
//	}
//
//	/**
//	 * Tests addCustomer method when all fields are empty.
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testAddCustomer_invalidDataAllEmpty() {
//		Customer customer = new Customer();
//		customer.setFirstName("");
//		customer.setLastName("");
//		customer.setEmail("");
//		customer.setAddress("");
//		customer.setCompany("");
//		customer.setPhoneNumber("");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		Mockito.when(custRepo.save(customer)).thenReturn(customer);
//		ResponseDto response = custService.addCustomer(customer);
//		String message = "FirstName cannot be null or empty, " + "LastName cannot be null or empty, "
//				+ "Email cannot be null or empty, " + "Address cannot be null or empty, "
//				+ "Company name cannot be null or empty, " + "Phone Number cannot be null or empty";
//
//		assertEquals(message, response.getMessage(), "Checking message");
//		assertEquals(Constant.BAD_REQUEST, response.getStatus(), "Checking status");
//		assertEquals("Pawan Thapa", customer.getCreatedBy(), "Checking created by");
//		assertEquals("Pawan Thapa", customer.getModifiedBy(), "Checking modified by");
//	}
//
//	/**
//	 * Tests addCustomer method when all fields are null.
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testAddCustomer_invalidDataAllNull() {
//		Customer customer = new Customer();
//		customer.setFirstName(null);
//		customer.setLastName(null);
//		customer.setEmail(null);
//		customer.setAddress(null);
//		customer.setCompany(null);
//		customer.setPhoneNumber(null);
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		String message = "FirstName cannot be null or empty, " + "LastName cannot be null or empty, "
//				+ "Email cannot be null or empty, " + "Address cannot be null or empty, "
//				+ "Company name cannot be null or empty, " + "Phone Number cannot be null or empty";
//
//		Mockito.when(custRepo.save(customer)).thenReturn(customer);
//		ResponseDto response = custService.addCustomer(customer);
//		assertEquals(message, response.getMessage(), "Checking message");
//		assertEquals(Constant.BAD_REQUEST, response.getStatus(), "Checking status");
//		assertEquals("Pawan Thapa", customer.getCreatedBy(), "Checking created by");
//		assertEquals("Pawan Thapa", customer.getModifiedBy(), "Checking modified by");
//	}
//
//	/**
//	 * Tests addCustomer method with a mix of valid, empty, and null fields.
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testAddCustomer_invalidDataEmptyAndNull() {
//		Customer customer = new Customer();
//		customer.setFirstName("Pawan");
//		customer.setLastName("");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress(null);
//		customer.setCompany("");
//		customer.setPhoneNumber("");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		String message = "LastName cannot be null or empty, " + "Address cannot be null or empty, "
//				+ "Company name cannot be null or empty, " + "Phone Number cannot be null or empty";
//
//		Mockito.when(custRepo.save(customer)).thenReturn(customer);
//		ResponseDto response = custService.addCustomer(customer);
//		assertEquals(message, response.getMessage(), "Checking message");
//		assertEquals(Constant.BAD_REQUEST, response.getStatus(), "Checking status");
//		assertEquals("Pawan Thapa", customer.getCreatedBy(), "Checking created by");
//		assertEquals("Pawan Thapa", customer.getModifiedBy(), "Checking modified by");
//	}
//
//	/**
//	 * Tests getCustomerById method with a valid ID.
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testgetCustomerById_validId() {
//		Customer customer = new Customer();
//		int id = 221;
//		customer.setId(id);
//		customer.setFirstName("Pawan");
//		customer.setLastName("Thapa");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress("delhi");
//		customer.setCompany("p2sme");
//		customer.setPhoneNumber("9319042883");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		Mockito.when(custRepo.findById(id)).thenReturn(Optional.of(customer));
//		ResponseDto response = custService.getCustomerById(id);
//
//		assertEquals("Customer fetched successfully. ", response.getMessage(), "Checking message");
//		assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
//		assertEquals("Pawan Thapa", customer.getCreatedBy(), "Checking created by");
//		assertEquals("Pawan Thapa", customer.getModifiedBy(), "Checking modified by");
//	}
//
//	/**
//	 * Tests getCustomerById method with an invalid ID.
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testgetCustomerById_invalidId() {
//		Customer customer = new Customer();
//		int id = 221;
//		customer.setId(id);
//		customer.setFirstName("Pawan");
//		customer.setLastName("Thapa");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress("delhi");
//		customer.setCompany("p2sme");
//		customer.setPhoneNumber("9319042883");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		Mockito.when(custRepo.findById(id)).thenReturn(Optional.of(customer));
//		ResponseDto response = custService.getCustomerById(222);
//
//		assertEquals("Customer fetch failed. ", response.getMessage(), "Checking message");
//		assertEquals(Constant.FAILED, response.getStatus(), "Checking status");
//		assertEquals("Pawan Thapa", customer.getCreatedBy(), "Checking created by");
//		assertEquals("Pawan Thapa", customer.getModifiedBy(), "Checking modified by");
//	}
//
//	/**
//	 * Tests getAllCustomer method.
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testgetAllCustomer_valid() {
//		List<Customer> custList = new ArrayList<>();
//		Customer customer = new Customer();
//		int id = 221;
//		customer.setId(id);
//		customer.setFirstName("Pawan");
//		customer.setLastName("Thapa");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress("delhi");
//		customer.setCompany("p2sme");
//		customer.setPhoneNumber("9319042883");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//		custList.add(customer);
//
//		Mockito.when(custRepo.findAll()).thenReturn(custList);
//		assertEquals(1, custService.getAllCustomer().size(), "Checking list size");
//	}
//
//	/**
//	 * Tests updateCustomer method with a valid ID.
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testupdateCustomer_valid() {
//		Customer customerInDB = new Customer();
//		customerInDB.setId(221);
//		customerInDB.setFirstName("Amrit");
//		customerInDB.setAddress("Allahabad");
//
//		Mockito.when(custRepo.findById(221)).thenReturn(Optional.of(customerInDB));
//		Mockito.when(custRepo.save(customerInDB)).thenReturn(customerInDB);
//
//		Customer customer = new Customer();
//		customer.setId(221);
//		customer.setFirstName("Pawan");
//		customer.setLastName("Thapa");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress("delhi");
//		customer.setCompany("p2sme");
//		customer.setPhoneNumber("9319042883");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		ResponseDto response = custService.updateCustomer(customer);
//
//		assertEquals("Updated successfully. ", response.getMessage(), "Checking message");
//		assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
//		assertEquals("Pawan Thapa", customer.getCreatedBy(), "Checking created by");
//		assertEquals("Pawan Thapa", customer.getModifiedBy(), "Checking modified by");
//	}
//
//	/**
//	 * Tests updateCustomer method with an invalid ID.
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testupdateCustomer_invalidId() {
//		Customer customerInDB = new Customer();
//		customerInDB.setId(221);
//		customerInDB.setFirstName("Amrit");
//		customerInDB.setAddress("Allahabad");
//
//		Mockito.when(custRepo.findById(221)).thenReturn(Optional.of(customerInDB));
//		Mockito.when(custRepo.save(customerInDB)).thenReturn(customerInDB);
//
//		Customer customer = new Customer();
//		customer.setId(221);
//		customer.setFirstName("Pawan");
//		customer.setLastName("Thapa");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress("delhi");
//		customer.setCompany("p2sme");
//		customer.setPhoneNumber("9319042883");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		ResponseDto response = custService.updateCustomer(customer);
//
//		assertEquals("Update failed. ", response.getMessage(), "Checking message");
//		assertEquals(Constant.FAILED, response.getStatus(), "Checking status");
//		assertEquals("Pawan Thapa", customer.getCreatedBy(), "Checking created by");
//		assertEquals("Pawan Thapa", customer.getModifiedBy(), "Checking modified by");
//	}
//
//	/**
//	 * tests deleteCustomerById method when id is valid(customer is present in DB)
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testdeleteCustomerById_validId() {
//		// Create object
//		Customer customer = new Customer();
//		int id = 221;
//		customer.setId(id);
//		customer.setFirstName("Pawan");
//		customer.setLastName("Thapa");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress("delhi");
//		customer.setCompany("p2sme");
//		customer.setPhoneNumber("9319042883");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		// method used in implementation
//		Mockito.when(custRepo.findById(id)).thenReturn(Optional.of(customer));
//		// Get response using the orignal function
//		ResponseDto response = custService.deleteCustomerById(221);
//
//		// assert response
//		assertEquals("Checking message", "Customer deleted successfully. ", response.getMessage());
//		assertEquals("Checking status", Constant.SUCCESS, response.getStatus());
//		assertEquals("Checking created by ", "Pawan Thapa", customer.getCreatedBy());
//		assertEquals("Checking modified by ", "Pawan Thapa", customer.getModifiedBy());
//
//	}
//
//	/**
//	 * tests deleteCustomerById method when id is invalid(customer is not present in
//	 * DB)
//	 *
//	 * @author pawanthapa
//	 */
//	@Test
//	public void testdeleteCustomerById_invalidId() {
//		// Create object
//		Customer customer = new Customer();
//		int id = 221;
//		customer.setId(id);
//		customer.setFirstName("Pawan");
//		customer.setLastName("Thapa");
//		customer.setEmail("pawan@gmail.com");
//		customer.setAddress("delhi");
//		customer.setCompany("p2sme");
//		customer.setPhoneNumber("9319042883");
//		customer.setCreatedBy("Pawan Thapa");
//		customer.setModifiedBy("Pawan Thapa");
//
//		// method used in implementation
//		Mockito.when(custRepo.findById(id)).thenReturn(Optional.of(customer));
//		// Get response using the orignal function
//		ResponseDto response = custService.deleteCustomerById(300);
//
//		// assert response
//		assertEquals( "Customer does not exist. ", response.getMessage(), "Checking message");
//		assertEquals( Constant.FAILED, response.getStatus(), "Checking status");
//		assertEquals( "Pawan Thapa", customer.getCreatedBy(), "Checking created by ");
//		assertEquals( "Pawan Thapa", customer.getModifiedBy(), "Checking modified by ");
//
//	}
//
//}
//
