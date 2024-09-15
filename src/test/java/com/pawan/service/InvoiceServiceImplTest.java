package com.pawan.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pawan.dto.ResponseDto;
import com.pawan.model.Invoice;
import com.pawan.repository.InvoiceRepository;
import com.pawan.utils.Constant;

@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebAppConfiguration.class })
public class InvoiceServiceImplTest {
	/*
	@InjectMocks
	private InvoiceServiceImpl invoiceService;

	@Mock
	private InvoiceRepository invoiceRepo;

	@BeforeEach
	public void init() {
		Invoice invoice = new Invoice();
		Mockito.when(invoiceRepo.findById(1)).thenReturn(Optional.of(invoice));
	}

	Date date = new Date();
	long time = date.getTime();
	Timestamp ts = new Timestamp(time);

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
		assertEquals("Invoice added successfully. ", response.getMessage(), "Checking response message");
		assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
		assertEquals("Pawan Thapa", invoice.getCreatedBy(), "Checking created by");
		assertEquals("Pawan Thapa", invoice.getModifiedBy(), "Checking modified by");
	}

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

		assertEquals(message, response.getMessage(), "Checking message");
		assertEquals(Constant.BAD_REQUEST, response.getStatus(), "Checking status");
		assertEquals("Pawan Thapa", invoice.getCreatedBy(), "Checking created by");
		assertEquals("Pawan Thapa", invoice.getModifiedBy(), "Checking modified by");
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
		Mockito.when(invoiceRepo.findById(1)).thenReturn(Optional.of(invoice));
		ResponseDto response = invoiceService.getInvoiceById(1);

		assertEquals("Invoice fetched successfully. ", response.getMessage(), "Checking message");
		assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
		assertEquals(invoice, response.getData(), "Checking data");
		assertEquals("Pawan Thapa", invoice.getCreatedBy(), "Checking created by");
		assertEquals("Pawan Thapa", invoice.getModifiedBy(), "Checking modified by");
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
		Mockito.when(invoiceRepo.findById(1)).thenReturn(Optional.of(invoice));
		ResponseDto response = invoiceService.getInvoiceById(2);

		assertEquals("Invoice fetch failed. ", response.getMessage(), "Checking message");
		assertEquals(Constant.FAILED, response.getStatus(), "Checking status");
		assertEquals("Pawan Thapa", invoice.getCreatedBy(), "Checking created by");
		assertEquals("Pawan Thapa", invoice.getModifiedBy(), "Checking modified by");
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

		assertEquals(2, loi.size());
		assertEquals("Pawan Thapa", invoice.getCreatedBy(), "Checking created by");
		assertEquals("Pawan Thapa", invoice.getModifiedBy(), "Checking modified by");
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
		Mockito.when(invoiceRepo.findById(1)).thenReturn(Optional.of(invoice));

		ResponseDto response = invoiceService.deleteInvoiceById(1);
		assertEquals("Invoice deleted successfully. ", response.getMessage(), "Checking message");
		assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
		assertEquals("Pawan Thapa", invoice.getCreatedBy(), "Checking created by");
		assertEquals("Pawan Thapa", invoice.getModifiedBy(), "Checking modified by");
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
		Mockito.when(invoiceRepo.findById(1)).thenReturn(Optional.of(invoice));

		ResponseDto response = invoiceService.deleteInvoiceById(2);
		assertEquals("Invoice does not exist. ", response.getMessage(), "Checking message");
		assertEquals(Constant.FAILED, response.getStatus(), "Checking status");
		assertEquals("Pawan Thapa", invoice.getCreatedBy(), "Checking created by");
		assertEquals("Pawan Thapa", invoice.getModifiedBy(), "Checking modified by");
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

		Mockito.when(invoiceRepo.findById(1)).thenReturn(Optional.of(invoice));
		ResponseDto response = invoiceService.getInvoiceByIdAndStatus(1);

		assertEquals("Invoice fetched successfully. ", response.getMessage(), "Checking message");
		assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
		assertEquals(invoice, response.getData(), "Checking data");
	}

	 */
}