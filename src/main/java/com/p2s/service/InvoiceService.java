/**
 * 
 */
package com.p2s.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.p2s.dto.ResponseDto;
import com.p2s.model.Invoice;

/**
 * @author pawanthapa
 *
 */
@Service
public interface InvoiceService {

	/**
	 * saves the invoice in the repository
	 * 
	 * @param ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto saveInvoice(Invoice invoice);

	/**
	 * fetches the invoice from repository using id and returns it
	 * 
	 * @param invoiceId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto getInvoiceById(int invoiceId);

	/**
	 * Fetches Invoice List using Customer Id
	 * 
	 * @param int
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto getInvoicesByCustomerId(int customerId);

	/**
	 * returns all the invoices in a list
	 * 
	 * @return List<Invoice>
	 * @author pawanthapa
	 */
	public List<Invoice> getAllInvoices();

	/**
	 * deletes the invoice using id
	 * 
	 * @param id
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto deleteInvoiceById(int invoiceId);

	/**
	 * Fetches Invoice List when status is pending or partially pending
	 * 
	 * @param int
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto getInvoiceByIdAndStatus(int customerid);

	/**
	 * fetches the list of distinct customer id
	 * 
	 * @return List<Integer>
	 * @author pawanthapa
	 */
	public List<Integer> getAllDistinctCustomerId();
}
