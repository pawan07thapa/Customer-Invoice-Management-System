package com.p2s.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.p2s.model.Invoice;
import com.p2s.repository.InvoiceRepository;
import com.p2s.utils.Constant;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class })
public class InvoiceServiceImplTest {

	@InjectMocks
	private InvoiceServiceImpl invoiceService;

	@Mock
	private InvoiceRepository invoiceRepo;

	@Before
	public void init() {
		Invoice invoice = new Invoice();

		Mockito.when(invoiceRepo.findOne(1)).thenReturn(invoice);
	}

	Date date = new Date();
	long time = date.getTime();
	Timestamp ts = new Timestamp(time);

	/**
	 * tests addInvoice method with valid data
	 * 
	 * @author pawanthapa
	 */
	@Test
	public void testSaveInvoice_validData() {
		Invoice invoice = new Invoice();
		invoice.setCustomerId(2);
		invoice.setInvoiceDate(ts);
		invoice.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice.setInvoiceAmount("12345");
		invoice.setInvoicePendingAmount("12345");
		invoice.setCreatedBy("Pawan Thapa");
		invoice.setModifiedBy("Pawan Thapa");
		Mockito.when(invoiceRepo.save(invoice)).thenReturn(invoice);

		ResponseDto response = invoiceService.saveInvoice(invoice);
		Assert.assertEquals("Checking reponse message ", "Invoice added successfully. ", response.getMessage());
		Assert.assertEquals("Checking status ", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", invoice.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", invoice.getModifiedBy());

	}

	/**
	 * This method checks addInvoice method when all fields are empty
	 *
	 * @author pawanthapa
	 */
	@Test
	public void testSaveInvoice_invalidDataAllEmpty() {
		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(-1);
		invoice.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice.setInvoiceAmount("");
		invoice.setInvoicePendingAmount("12345");
		invoice.setCreatedBy("Pawan Thapa");
		invoice.setModifiedBy("Pawan Thapa");

		Mockito.when(invoiceRepo.save(invoice)).thenReturn(invoice);
		ResponseDto response = invoiceService.saveInvoice(invoice);
		String message = "Customer id cannot be less than or equal to zero, " + "Amount cannot be null, empty or zero ";

		Assert.assertEquals("Checking message", message, response.getMessage());
		Assert.assertEquals("Checking status", Constant.BAD_REQUEST, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", invoice.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", invoice.getModifiedBy());

	}

	@Test
	public void testGetInvoiceById_validId() {
		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(-1);
		invoice.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice.setInvoiceAmount("");
		invoice.setInvoicePendingAmount("12345");
		invoice.setCreatedBy("Pawan Thapa");
		invoice.setModifiedBy("Pawan Thapa");
		Mockito.when(invoiceRepo.findOne(1)).thenReturn(invoice);
		ResponseDto response = invoiceService.getInvoiceById(1);

		Assert.assertEquals("Checking message", "Invoice fetched successfully. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking data ", invoice, response.getData());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", invoice.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", invoice.getModifiedBy());
	}

	@Test
	public void testGetInvoiceById_invalidId() {
		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(-1);
		invoice.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice.setInvoiceAmount("");
		invoice.setCreatedBy("Pawan Thapa");
		invoice.setModifiedBy("Pawan Thapa");
		Mockito.when(invoiceRepo.findOne(1)).thenReturn(invoice);
		ResponseDto response = invoiceService.getInvoiceById(2);

		Assert.assertEquals("Checking message", "Invoice fetch failed. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.FAILED, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", invoice.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", invoice.getModifiedBy());
	}

	public void testGetAllInvoices_validData() {
		Invoice invoice1 = new Invoice();
		invoice1.setId(1);
		invoice1.setCustomerId(-1);
		invoice1.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice1.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice1.setInvoiceAmount("");
		invoice1.setCreatedBy("Pawan Thapa");
		invoice1.setModifiedBy("Pawan Thapa");

		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(-1);
		invoice.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice.setInvoiceAmount("");
		invoice.setCreatedBy("Pawan Thapa");
		invoice.setModifiedBy("Pawan Thapa");

		List<Invoice> listOfInvoice = new ArrayList<Invoice>();
		listOfInvoice.add(invoice);
		listOfInvoice.add(invoice1);
		Mockito.when(invoiceRepo.findAll()).thenReturn(listOfInvoice);
		List<Invoice> loi = invoiceService.getAllInvoices();

		Assert.assertEquals(2, loi.size());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", invoice.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", invoice.getModifiedBy());
	}

	@Test
	public void testDeleteInvoiceById_validId() {
		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(-1);
		invoice.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice.setInvoiceAmount("");
		invoice.setCreatedBy("Pawan Thapa");
		invoice.setModifiedBy("Pawan Thapa");
		Mockito.when(invoiceRepo.findOne(1)).thenReturn(invoice);
		// Mockito.when(invoiceRepo.delete(1)).thenReturn(invoice);

		ResponseDto response = invoiceService.deleteInvoiceById(1);
		Assert.assertEquals("Checking message", "Invoice deleted successfully. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", invoice.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", invoice.getModifiedBy());
	}

	@Test
	public void testDeleteInvoiceById_invalidId() {
		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(1);
		invoice.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice.setInvoiceAmount("");
		invoice.setCreatedBy("Pawan Thapa");
		invoice.setModifiedBy("Pawan Thapa");
		Mockito.when(invoiceRepo.findOne(1)).thenReturn(invoice);
		// Mockito.when(invoiceRepo.delete(1)).thenReturn(invoice);

		ResponseDto response = invoiceService.deleteInvoiceById(2);
		Assert.assertEquals("Checking message", "Invoice does not exist. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.FAILED, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", invoice.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", invoice.getModifiedBy());
	}

	@Test
	public void testGetInvoiceByIdAndStatus_validId() {
		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(1);
		invoice.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice.setInvoiceAmount("");
		invoice.setInvoicePendingAmount("365434");
		invoice.setStatus("Pending");
		invoice.setCreatedBy("Pawan Thapa");
		invoice.setModifiedBy("Pawan Thapa");
		
		Invoice invoice1 = new Invoice();
		invoice1.setId(2);
		invoice1.setCustomerId(2);
		invoice1.setInvoiceDate(Timestamp.valueOf("2022-03-10 00:00:00"));
		invoice1.setInvoiceDueDate(Timestamp.valueOf("2019-03-10 00:00:00"));
		invoice1.setInvoiceAmount("");
		invoice1.setInvoicePendingAmount("365434");
		invoice1.setStatus("Approved");
		invoice1.setCreatedBy("Pawan Thapa");
		invoice1.setModifiedBy("Pawan Thapa");
		List<String> status=new ArrayList<>();
		status.add("Pending");
		status.add("Partially pending");
		
		Mockito.when(invoiceRepo.findByCustomerIdAndStatusIn(invoice.getCustomerId(), status)).thenReturn(invoice);
		// Mockito.when(invoiceRepo.delete(1)).thenReturn(invoice);

		ResponseDto response = invoiceService.getInvoiceByIdAndStatus(invoice.getCustomerId());
		Assert.assertEquals("Checking message", "Fetching invoice successful. ", response.getMessage());
		Assert.assertEquals("Checking status", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", invoice.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", invoice.getModifiedBy());
	}
}
