/**
 * 
 */
package com.p2s.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
import com.p2s.model.Payment;
import com.p2s.repository.InvoiceRepository;
import com.p2s.repository.PaymentRepository;
import com.p2s.utils.Constant;

/**
 * @author pawanthapa
 *
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class })
public class PaymentServiceImplTest {

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
		Mockito.when(invoiceRepo.findOne(1)).thenReturn(invoice);

		ResponseDto response = paymentService.savePayment(payment);
		Assert.assertEquals("Checking reponse message ", "Payment added successfully. ", response.getMessage());
		Assert.assertEquals("Checking status ", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", payment.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", payment.getModifiedBy());
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
				+ "Amount cannot be less than or equal to zero and cannot be greater than pending amount , "
				+ "Payment Voucher cannot be null or empty";
		Mockito.when(paymentRepo.save(payment)).thenReturn(payment);
		Mockito.when(invoiceRepo.findOne(1)).thenReturn(invoice);

		ResponseDto response = paymentService.savePayment(payment);
		Assert.assertEquals("Checking reponse message ", message, response.getMessage());
		Assert.assertEquals("Checking status ", Constant.BAD_REQUEST, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", payment.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", payment.getModifiedBy());
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

		Mockito.when(paymentRepo.findOne(payment.getId())).thenReturn(payment);

		ResponseDto response = paymentService.getPaymentById(payment.getId());
		Assert.assertEquals("Checking reponse message ", "Payment fetched successfully. ", response.getMessage());
		Assert.assertEquals("Checking status ", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", payment.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", payment.getModifiedBy());

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

		Mockito.when(paymentRepo.findOne(2)).thenReturn(payment);

		ResponseDto response = paymentService.getPaymentById(payment.getId());
		Assert.assertEquals("Checking reponse message ", "Payment fetch failed. ", response.getMessage());
		Assert.assertEquals("Checking status ", Constant.FAILED, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", payment.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", payment.getModifiedBy());

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
		Assert.assertEquals(2, list.size());
		Assert.assertEquals("Checking reponse message ", "Fetching payments successful. ",
				"Fetching payments successful. ");
		Assert.assertEquals("Checking status ", Constant.SUCCESS, Constant.SUCCESS);
		Assert.assertEquals("Checking created by ", "Pawan Thapa", payment.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", payment.getModifiedBy());

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

		Mockito.when(paymentRepo.findOne(1)).thenReturn(payment);

		ResponseDto response = paymentService.deletePaymentById(payment.getId());
		Assert.assertEquals("Checking reponse message ", "Payment deleted successfully. ", response.getMessage());
		Assert.assertEquals("Checking status ", Constant.SUCCESS, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", payment.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", payment.getModifiedBy());

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

		Mockito.when(paymentRepo.findOne(1)).thenReturn(payment);

		ResponseDto response = paymentService.deletePaymentById(2);
		Assert.assertEquals("Checking reponse message ", "Payment does not exist. ", response.getMessage());
		Assert.assertEquals("Checking status ", Constant.FAILED, response.getStatus());
		Assert.assertEquals("Checking created by ", "Pawan Thapa", payment.getCreatedBy());
		Assert.assertEquals("Checking modified by ", "Pawan Thapa", payment.getModifiedBy());

	}
}
