/**
 * 
 */
package com.pawan.controller;

import java.util.List;

import com.pawan.service.CustomerService;
import com.pawan.service.PaymentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pawan.dto.ResponseDto;
import com.pawan.model.Payment;
import com.pawan.utils.Constant;

/**
 * @author pawanthapa
 *
 */
@Controller
public class PaymentControllerImpl implements PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentControllerImpl.class);


	private final PaymentServiceImpl paymentService;
	private final CustomerService customerService;

	 PaymentControllerImpl(PaymentServiceImpl paymentService, CustomerService customerService) {
		this.paymentService = paymentService;
		this.customerService = customerService;
	}

	/**
	 * This method directs the payment towards the addPayment form
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView addPayment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers", customerService.getAllCustomer());
		// Add invoice dropdown whose payments are pending or partially pending
		mv.setViewName("addPayment");
		logger.info("Directed to addPayment form. ");
		return mv;
	}

	/**
	 * Saving the payment after the form has been filled
	 * 
	 * @param payment
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@ResponseBody
	@Override
	public ResponseEntity<ResponseDto> savePayment(@RequestBody Payment payment) {
		try {
			logger.info("Saving payment started. ");
			ResponseDto response = paymentService.savePayment(payment);
			logger.info("Saving payment successful. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Saving payment failed. " + e.getMessage());
			return new ResponseEntity<>(new ResponseDto("Add payment failed. ", 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * saves the payment in db
	 * 
	 * @param paymentId
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@ResponseBody
	@Override
	public ResponseEntity<ResponseDto> getPaymentById(@PathVariable("id") int paymentId) {
		try {
			logger.info("Fetching payment started. ");
			ResponseDto response = paymentService.getPaymentById(paymentId);
			logger.info("Fetching payment completed. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Fetching payment failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("payment fetching failed. " + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * fetches the payment using PaymentId , adds it to ModelAndView Object. Used to
	 * show detail of an individual payment
	 * 
	 * @param paymentId
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView showPayment(@RequestParam int paymentId) {
		logger.info("Adding payment data to model. ");
		ModelAndView mv = new ModelAndView();
		mv.addObject("payment", paymentService.getPaymentById(paymentId).getData());
		mv.setViewName("paymentDetail");
		logger.info("Directed to paymentDetail.jsp. ");
		return mv;
	}

	/**
	 * fetches all the payments and returns them in a list
	 * 
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@Override
	public ResponseEntity<ResponseDto> getAllPayments() {
		try {
			logger.info("Fetching list of payments started. ");
			List<Payment> listOfpayments = paymentService.getAllPayments();
			logger.info("Fetching list of payments completed. ");
			return new ResponseEntity<>(new ResponseDto("Fetching payments successful. ", 0, listOfpayments.size(),
					listOfpayments, Constant.SUCCESS), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Fetching list of payment failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("Fetching payments failed." + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Adds all the payments to ModelAndView object and displays them in
	 * Payments.jsp. By default this will be the view and after applying customerId
	 * filter we will be calling another API
	 * 
	 * @param
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView showAllPayments() {
		logger.info("Adding all payments data to model. ");
		ModelAndView mv = new ModelAndView();
		mv.addObject("listOfPayments", paymentService.getAllPayments());
		mv.addObject("customers", customerService.getAllCustomer());
		mv.setViewName("payments");
		logger.info("Payment data added. ");
		return mv;
	}

	/**
	 * deletes payment using paymentId
	 * 
	 * @param
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@ResponseBody
	@Override
	public ResponseEntity<ResponseDto> deletePaymentById(@PathVariable("id") int paymentId) {
		try {
			logger.info("Deleting payment started. ");
			ResponseDto response = paymentService.deletePaymentById(paymentId);
			logger.info("Payment deleted successfully. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Deleting payment failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("Payment deletion Failed. " + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
