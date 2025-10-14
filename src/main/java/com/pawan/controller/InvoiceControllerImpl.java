/**
 * 
 */
package com.pawan.controller;

import java.util.List;

import com.pawan.service.CustomerService;
import com.pawan.service.InvoiceServiceImpl;
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
import com.pawan.model.Invoice;
import com.pawan.utils.Constant;

/**
 * @author pawanthapa
 *
 */
@Controller
public class InvoiceControllerImpl implements InvoiceController {

	/**
	 * Logger for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(InvoiceControllerImpl.class);

	private final InvoiceServiceImpl invoiceService;
	private final CustomerService customerService;

	public InvoiceControllerImpl(InvoiceServiceImpl invoiceService, CustomerService customerService) {
		this.invoiceService = invoiceService;
		this.customerService = customerService;
	}

	/**
	 * This method directs the invoice towards the addInvoice form
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView addInvoice() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers", customerService.getAllCustomer());
		mv.setViewName("addInvoice");
		logger.info("Directed to addInvoice form. ");
		return mv;
	}

	/**
	 * Saving the invoice after the form has been filled
	 * 
	 * @param
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@ResponseBody
	@Override
	public ResponseEntity<ResponseDto> saveInvoice(@RequestBody Invoice invoice) {
		try {
			logger.info("Saving invoice started. ");
			ResponseDto response = invoiceService.saveInvoice(invoice);
			logger.info("Saving invoice successful. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Saving invoice failed. " + e.getMessage());
			return new ResponseEntity<>(new ResponseDto("Add invoice failed. ", 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * saves the invoice in db
	 * 
	 * @param invoiceId
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@ResponseBody
	@Override
	public ResponseEntity<ResponseDto> getInvoiceById(@PathVariable("id") int invoiceId) {
		try {
			logger.info("Fetching invoice started. ");
			ResponseDto response = invoiceService.getInvoiceById(invoiceId);
			logger.info("Fetching invoice completed. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Fetching invoice failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("invoice fetching failed. " + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * fetches the invoice using InvoiceId , adds it to ModelAndView Object. Used to
	 * show detail of an individual invoice
	 * 
	 * @param invoiceId
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView showInvoice(@RequestParam int invoiceId) {
		logger.info("Adding invoice data to model. ");
		ModelAndView mv = new ModelAndView();
		mv.addObject("invoice", invoiceService.getInvoiceById(invoiceId).getData());
		mv.setViewName("invoiceDetail");
		logger.info("Directed to invoiceDetail.jsp. ");
		return mv;
	}

	/**
	 * fetches all the invoices and returns them in a list
	 * 
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@Override
	public ResponseEntity<ResponseDto> getAllInvoices() {
		try {
			logger.info("Fetching list of invoices started. ");
			List<Invoice> listOfinvoices = invoiceService.getAllInvoices();
			logger.info("Fetching list of invoices completed. ");
			return new ResponseEntity<>(new ResponseDto("Fetching invoices successful. ", 0, listOfinvoices.size(),
					listOfinvoices, Constant.SUCCESS), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Fetching list of invoice failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("Fetching invoices failed." + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Adds all the invoices to ModelAndView object and displays them in
	 * Invoices.jsp. By default this will be the view and after
	 * applying customerId filter we will be calling another API
	 * 
	 * @param
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView showAllInvoices() {
		logger.info("Adding all invoices data to model. ");
		ModelAndView mv = new ModelAndView();
		mv.addObject("listOfInvoices", invoiceService.getAllInvoices());
		mv.addObject("customers" ,customerService.getAllCustomer());
//		mv.addObject("customers" ,invoiceService.getAllDistinctCustomerId());
		mv.setViewName("invoices");
		logger.info("Invoice data added. ");
		return mv;
	}

	/**
	 * Updates the information about invoice
	 * 
	 * @param invoice
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@ResponseBody
	@Override
	public ResponseEntity<ResponseDto> updateInvoice(@RequestBody Invoice invoice) {
		
		return new ResponseEntity<>(new ResponseDto("yes", 0, 0, null, "success"), HttpStatus.ACCEPTED);
	}

	/**
	 * deletes invoice using invoiceId
	 * 
	 * @param id
	 * @return ResponseEntity<ResponseDto>
	 * @author pawanthapa
	 */
	@ResponseBody
	@Override
	public ResponseEntity<ResponseDto> deleteInvoiceById(@PathVariable("id") int id) {
		try {
			logger.info("Deleting invoice started. ");
			ResponseDto response = invoiceService.deleteInvoiceById(id);
			logger.info("Invoice deleted successfully. ");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Deleting invoice failed. " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseDto("Invoice deletion Failed. " + e.getMessage(), 0, 0, null, Constant.FAILED),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ModelAndView displayAllInvoices() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listOfInvoices", invoiceService.getAllInvoices());
		mv.setViewName("invoices");
		return mv;
	}
	/**
	 * Gets invoices filtered by customer ID
	 * Returns to the same invoices.jsp view - JavaScript handles the filtering UI
	 * REFACTORED: Removed separate invoicesUsingCustomerId.jsp - merged into invoices.jsp
	 * 
	 * @param customerId The customer ID to filter by
	 * @return ModelAndView with filtered invoices
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView getInvoicesByCustomerId(@PathVariable("id") int customerId) {
		logger.info("Fetching invoices for customer ID: {}", customerId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("listOfInvoices", invoiceService.getInvoicesByCustomerId(customerId).getData());
		mv.addObject("customers", customerService.getAllCustomer());
		mv.addObject("selectedCustomerId", customerId); // Add selected customer for pre-selection in dropdown
		mv.setViewName("invoices"); // CHANGED: Use invoices.jsp instead of invoicesUsingCustomerId.jsp
		logger.info("Filtered invoices for customer: {}", customerId);
		return mv;
	}
}
