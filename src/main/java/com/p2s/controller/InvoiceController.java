/**
 * 
 */
package com.p2s.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Invoice;

/**
 * @author pawanthapa
 *
 */
public interface InvoiceController {

	/**
	 * This method directs the invoice towards the addInvoice form
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/addInvoice")
	public ModelAndView addInvoice();

	/**
	 * Saving the invoice after the form has been filled
	 * 
	 * @param invoice
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@PostMapping("/invoice")
	@ResponseBody
	public ResponseEntity<ResponseDto> saveInvoice(@RequestBody Invoice invoice);

	/**
	 * saves the invoice in db
	 * 
	 * @param id
	 * @return ResponseBody<ResponseDto>
	 * @author pawanthapa
	 */
	@GetMapping("/invoice/{id}")
	@ResponseBody
	public ResponseEntity<ResponseDto> getInvoiceById(@PathVariable("id") int id);

	/**
	 * fetches the invoice using InvoiceId , adds it to ModelAndView Object. Used to
	 * show detail of an individual invoice
	 * 
	 * @param id
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/showInvoice")
	public ModelAndView showInvoice(@RequestParam int invoiceId);

	/**
	 * fetches all the invoices and returns them in a list
	 * 
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@GetMapping("/invoices")
	public ResponseEntity<ResponseDto> getAllInvoices();

	/**
	 * Adds all the invoices to ModelAndView object and displays them in
	 * Invoices.jsp
	 * 
	 * @param Invoice
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/showAllInvoices")
	public ModelAndView showAllInvoices();

	/**
	 * Updates the information about invoice
	 * 
	 * @param Invoice
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@PutMapping("/invoice")
	@ResponseBody
	public ResponseEntity<ResponseDto> updateInvoice(@RequestBody Invoice invoice);

	/**
	 * deletes invoice using invoiceId
	 * 
	 * @param id
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@DeleteMapping("/invoice/{id}")
	@ResponseBody
	public ResponseEntity<ResponseDto> deleteInvoiceById(@PathVariable("id") int id);
	
	@RequestMapping("/invoices/{id}")
	public ModelAndView getInvoicesByCustomerId(@PathVariable("id") int customerId);
	
	
}
