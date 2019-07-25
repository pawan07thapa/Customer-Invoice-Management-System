/**
 * 
 */
package com.p2s.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Payment;

/**
 * @author pawanthapa
 *
 */
@Controller
public interface PaymentController {

	/**
	 * This method directs the payment towards the addPayment form
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/addPayment")
	public ModelAndView addPayment();

	/**
	 * Saving the payment after the form has been filled
	 * 
	 * @param payment
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@PostMapping("/payment")
	@ResponseBody
	public ResponseEntity<ResponseDto> savePayment(@RequestBody Payment payment);

	/**
	 * saves the payment in db
	 * 
	 * @param id
	 * @return ResponseBody<ResponseDto>
	 * @author pawanthapa
	 */
	@GetMapping("/payment/{id}")
	@ResponseBody
	public ResponseEntity<ResponseDto> getPaymentById(@PathVariable("id") int id);

	/**
	 * fetches the payment using PaymentId , adds it to ModelAndView Object. Used to
	 * show detail of an individual payment
	 * 
	 * @param id
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/showPayment")
	public ModelAndView showPayment(@RequestParam int paymentId);

	/**
	 * fetches all the payments and returns them in a list
	 * 
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@GetMapping("/payments")
	public ResponseEntity<ResponseDto> getAllPayments();
	
	/**
	 * Adds all the payments to ModelAndView object and displays them in
	 * Payments.jsp
	 * 
	 * @param Payment
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/showAllPayments")
	public ModelAndView showAllPayments();

	/**
	 * deletes payment using paymentId
	 * 
	 * @param id
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@DeleteMapping("/payment/{id}")
	@ResponseBody
	public ResponseEntity<ResponseDto> deletePaymentById(@PathVariable("id") int paymentId);
}
