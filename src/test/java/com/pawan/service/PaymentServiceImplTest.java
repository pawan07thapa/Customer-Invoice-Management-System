package com.pawan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
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
import com.pawan.model.Payment;
import com.pawan.repository.InvoiceRepository;
import com.pawan.repository.PaymentRepository;
import com.pawan.utils.Constant;

/**
 * @author pawanthapa
 *
 */
@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebAppConfiguration.class })
public class PaymentServiceImplTest {
/*
	@InjectMocks
	private PaymentServiceImpl paymentService;

	@Mock
	private PaymentRepository paymentRepo;
	@Mock
	private InvoiceRepository invoiceRepo;

	@Test
	public void testSavePayment_validData() {
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCustomerId(1);
		payment.setInvoiceId(1);
		payment.setPaymentVoucher("sdgfa");
		payment.setPaymentAmount(32425);
		payment.setCreatedBy("Pawan Thapa");
		payment.setModifiedBy("Pawan Thapa");

		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(2);
		invoice.setInvoicePendingAmount("34526");

		Mockito.when(paymentRepo.save(payment)).thenReturn(payment);
		Mockito.when(invoiceRepo.findById(1)).thenReturn(Optional.of(invoice));

		ResponseDto response = paymentService.savePayment(payment);
		Assertions.assertEquals("Payment added successfully. ", response.getMessage(), "Checking response message");
		Assertions.assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
		Assertions.assertEquals("Pawan Thapa", payment.getCreatedBy(), "Checking created by");
		Assertions.assertEquals("Pawan Thapa", payment.getModifiedBy(), "Checking modified by");
	}

	@Test
	public void testSavePayment_invalidDataAllEmptyFields() {
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCustomerId(-1);
		payment.setInvoiceId(0);
		payment.setPaymentVoucher("");
		payment.setPaymentAmount(0);
		payment.setCreatedBy("Pawan Thapa");
		payment.setModifiedBy("Pawan Thapa");

		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setCustomerId(2);
		invoice.setInvoicePendingAmount("34526");
		String message = "Customer id cannot be less than or equal to zero, "
				+ "Invoice id cannot be less than or equal to zero, "
				+ "Amount cannot be less than or equal to zero and cannot be greater than pending amount, "
				+ "Payment Voucher cannot be null or empty";
		Mockito.when(paymentRepo.save(payment)).thenReturn(payment);
		Mockito.when(invoiceRepo.findById(1)).thenReturn(Optional.of(invoice));

		ResponseDto response = paymentService.savePayment(payment);
		Assertions.assertEquals(message, response.getMessage(), "Checking response message");
		Assertions.assertEquals(Constant.BAD_REQUEST, response.getStatus(), "Checking status");
		Assertions.assertEquals("Pawan Thapa", payment.getCreatedBy(), "Checking created by");
		Assertions.assertEquals("Pawan Thapa", payment.getModifiedBy(), "Checking modified by");
	}

	@Test
	public void testGetPaymentById_validData() {
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCustomerId(1);
		payment.setInvoiceId(1);
		payment.setPaymentVoucher("sdgfa");
		payment.setPaymentAmount(32425);
		payment.setCreatedBy("Pawan Thapa");
		payment.setModifiedBy("Pawan Thapa");

		Mockito.when(paymentRepo.findById(payment.getId())).thenReturn(Optional.of(payment));

		ResponseDto response = paymentService.getPaymentById(payment.getId());
		Assertions.assertEquals("Payment fetched successfully. ", response.getMessage(), "Checking response message");
		Assertions.assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
		Assertions.assertEquals("Pawan Thapa", payment.getCreatedBy(), "Checking created by");
		Assertions.assertEquals("Pawan Thapa", payment.getModifiedBy(), "Checking modified by");
	}

	@Test
	public void testGetPaymentById_invalidId() {
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCustomerId(1);
		payment.setInvoiceId(1);
		payment.setPaymentVoucher("sdgfa");
		payment.setPaymentAmount(32425);
		payment.setCreatedBy("Pawan Thapa");
		payment.setModifiedBy("Pawan Thapa");

		Mockito.when(paymentRepo.findById(2)).thenReturn(Optional.of(payment));

		ResponseDto response = paymentService.getPaymentById(payment.getId());
		Assertions.assertEquals("Payment fetch failed. ", response.getMessage(), "Checking response message");
		Assertions.assertEquals(Constant.FAILED, response.getStatus(), "Checking status");
		Assertions.assertEquals("Pawan Thapa", payment.getCreatedBy(), "Checking created by");
		Assertions.assertEquals("Pawan Thapa", payment.getModifiedBy(), "Checking modified by");
	}

	@Test
	public void testGetAllPayments_valid() {
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCustomerId(1);
		payment.setInvoiceId(1);
		payment.setPaymentVoucher("sdgfa");
		payment.setPaymentAmount(32425);
		payment.setCreatedBy("Pawan Thapa");
		payment.setModifiedBy("Pawan Thapa");

		Payment payment1 = new Payment();
		payment1.setId(10);
		payment1.setCustomerId(10);
		payment1.setInvoiceId(10);
		payment1.setPaymentVoucher("sdgfa");
		payment1.setPaymentAmount(32425);
		payment1.setCreatedBy("Pawan Thapa");
		payment1.setModifiedBy("Pawan Thapa");

		List<Payment> listOfPayment = new ArrayList<>();
		listOfPayment.add(payment1);
		listOfPayment.add(payment);
		Mockito.when(paymentRepo.findAll()).thenReturn(listOfPayment);

		List<Payment> list = paymentService.getAllPayments();
		Assertions.assertEquals(2, list.size());
		Assertions.assertEquals("Fetching payments successful. ", "Fetching payments successful.", "Checking response message");
		Assertions.assertEquals(Constant.SUCCESS, Constant.SUCCESS, "Checking status");
		Assertions.assertEquals("Pawan Thapa", payment.getCreatedBy(), "Checking created by");
		Assertions.assertEquals("Pawan Thapa", payment.getModifiedBy(), "Checking modified by");
	}

	@Test
	public void testDeletePaymentById_validId() {
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCustomerId(1);
		payment.setInvoiceId(1);
		payment.setPaymentVoucher("sdgfa");
		payment.setPaymentAmount(32425);
		payment.setCreatedBy("Pawan Thapa");
		payment.setModifiedBy("Pawan Thapa");

		Mockito.when(paymentRepo.findById(1)).thenReturn(Optional.of(payment));

		ResponseDto response = paymentService.deletePaymentById(payment.getId());
		Assertions.assertEquals("Payment deleted successfully. ", response.getMessage(), "Checking response message");
		Assertions.assertEquals(Constant.SUCCESS, response.getStatus(), "Checking status");
		Assertions.assertEquals("Pawan Thapa", payment.getCreatedBy(), "Checking created by");
		Assertions.assertEquals("Pawan Thapa", payment.getModifiedBy(), "Checking modified by");
	}

	@Test
	public void testDeletePaymentById_invalidId() {
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCustomerId(1);
		payment.setInvoiceId(1);
		payment.setPaymentVoucher("sdgfa");
		payment.setPaymentAmount(32425);
		payment.setCreatedBy("Pawan Thapa");
		payment.setModifiedBy("Pawan Thapa");

		Mockito.when(paymentRepo.findById(1)).thenReturn(Optional.of(payment));

		ResponseDto response = paymentService.deletePaymentById(2);
		Assertions.assertEquals("Payment does not exist. ", response.getMessage(), "Checking response message");
		Assertions.assertEquals(Constant.FAILED, response.getStatus(), "Checking status");
		Assertions.assertEquals("Pawan Thapa", payment.getCreatedBy(), "Checking created by");
		Assertions.assertEquals("Pawan Thapa", payment.getModifiedBy(), "Checking modified by");
	}

 */
}
