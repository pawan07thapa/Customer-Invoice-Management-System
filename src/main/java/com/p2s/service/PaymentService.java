/**
 * 
 */
package com.p2s.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Payment;

/**
 * @author pawanthapa
 *
 */
@Service
public interface PaymentService {

	/**
	 * saves the payment in the repository
	 * 
	 * @param ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto savePayment(Payment payment);
	
	/**
	 * fetches the payment from repository using id and returns it
	 * 
	 * @param paymentId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto getPaymentById(int paymentId);
	
	/**
	 * returns all the payments in a list
	 * 
	 * @return List<Payment>
	 * @author pawanthapa
	 */
	public List<Payment> getAllPayments();
	
	/**
	 * deletes the payment using paymentId
	 * 
	 * @param id
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto deletePaymentById(int paymentId);

	

}
