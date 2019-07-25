/**
 * 
 */
package com.p2s.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.p2s.dto.ResponseDto;
import com.p2s.model.Invoice;
import com.p2s.service.CustomerService;
import com.p2s.service.InvoiceService;
import com.p2s.utils.Constant;

/**
 * @author pawanthapa
 *
 */
@Controller
public class InvoiceControllerImpl implements InvoiceController {

	/**
	 * Logger for debugging
	 */
	private static Logger logger = Logger.getLogger(InvoiceControllerImpl.class);

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private CustomerService customerService;

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
		mv.setViewName("addInvoice.jsp");
		logger.info("Directed to addInvoice form. ");
		return mv;
	}

	/**
	 * Saving the invoice after the form has been filled
	 * 
	 * @param Invoice
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
		mv.setViewName("invoiceDetail.jsp");
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
	 * @param Invoice
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
		mv.setViewName("invoices.jsp");
		logger.info("Invoice data added. ");
		return mv;
	}

	/**
	 * Updates the information about invoice
	 * 
	 * @param Invoice
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
		mv.setViewName("invoices.jsp");
		return mv;
	}
	/**
	 * When customerId will be seleted from dropdown
	 * submit -> eventListener->  call -> hits this API->returns data
	 * 
	 */
	@Override
	public ModelAndView getInvoicesByCustomerId(@PathVariable("id") int customerId){
		ModelAndView mv= new ModelAndView();
		mv.addObject("invoices", invoiceService.getInvoicesByCustomerId(customerId).getData());
		mv.addObject("customers", customerService.getAllCustomer());
		mv.setViewName("../invoicesUsingCustomerId.jsp");
		return mv;
	}
}
