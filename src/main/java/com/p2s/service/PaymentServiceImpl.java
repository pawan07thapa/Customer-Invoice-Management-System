/**
 * 
 */
package com.p2s.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Payment;
import com.p2s.repository.InvoiceRepository;
import com.p2s.repository.PaymentRepository;
import com.p2s.utils.Constant;

/**
 * @author pawanthapa
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	private static Logger logger = Logger.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentRepository repo;

	@Autowired
	private InvoiceRepository invoiceRepo;

	/**
	 * saves the payment in the repository
	 * 
	 * @param ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto savePayment(Payment payment) {
		logger.info("Saving payment started. ");
		String message = validatePayment(payment);
		if (!message.isEmpty()) {
			logger.info("Saving payment failed. ");
			return new ResponseDto(message, 0, 0, null, Constant.BAD_REQUEST);
		} else {
			payment.setCreatedBy("Pawan Thapa");
			payment.setModifiedBy("Pawan Thapa");
			repo.save(payment);
			logger.info("Saving payment successful. ");
			return new ResponseDto("Payment added successfully. ", 0, 0, payment, Constant.SUCCESS);
		}
	}

	/**
	 * validates the payment to be saved. If message is null then validated without
	 * errors else validation failed
	 * 
	 * @param payment
	 * @return String
	 * @author pawanthapa
	 */
	private String validatePayment(Payment payment) {
		String message = "";
		if (payment.getCustomerId() <= 0) {
			message += "Customer id cannot be less than or equal to zero, ";
		}
		if (payment.getInvoiceId() <= 0) {
			message += "Invoice id cannot be less than or equal to zero, ";
		}

		if (payment.getPaymentAmount() <= 0 || (payment.getPaymentAmount() > Integer
				.parseInt(invoiceRepo.findOne(payment.getCustomerId()).getInvoicePendingAmount()))) {
			message += "Amount cannot be less than or equal to zero and cannot be greater than pending amount , ";
		}
		if (payment.getPaymentVoucher() == null || payment.getPaymentVoucher() == "") {
			message += "Payment Voucher cannot be null or empty, ";
		}

		if (message.isEmpty())
			return "";
		else
			return message.substring(0, message.length() - 2);
	}

	/**
	 * fetches the payment from repository using id and returns it
	 * 
	 * @param paymentId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	@Override
	public ResponseDto getPaymentById(int paymentId) {
		logger.info("Fetching payment using with id " + paymentId);
		Payment payment = repo.findOne(paymentId);
		if (payment != null) {
			logger.info("Fetching payment using with id " + paymentId + " successful. ");
			return new ResponseDto("Payment fetched successfully. ", 0, 1, payment, Constant.SUCCESS);
		} else {
			logger.info("Fetching payment using with id " + paymentId + " failed. ");
			return new ResponseDto("Payment fetch failed. ", 0, 0, null, Constant.FAILED);
		}
	}

	/**
	 * returns all the payments in a list
	 * 
	 * @return List<Payment>
	 * @author pawanthapa
	 */
	@Override
	public List<Payment> getAllPayments() {
		logger.info("Fetching all payments. ");
		List<Payment> listOfPayments = repo.findAll();
		logger.info("Fetching payments successful. ");
		return listOfPayments;
	}

	/**
	 * deletes the payment using paymentId
	 * 
	 * @param id
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	@Override
	public ResponseDto deletePaymentById(int paymentId) {
		logger.info("Deletion with  paymentId " + paymentId + " started");
		if (repo.findOne(paymentId) == null) {
			logger.info("Payment does  not exist. ");
			return new ResponseDto("Payment does not exist. ", 0, 0, null, Constant.FAILED);
		} else {
			logger.info("Payment found. ");
			repo.delete(paymentId);
			logger.info("Deletion of paymentId " + paymentId + " done");
			return new ResponseDto("Payment deleted successfully. ", 0, 0, null, Constant.SUCCESS);
		}
	}
}
