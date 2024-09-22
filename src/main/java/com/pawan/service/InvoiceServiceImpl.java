
package com.pawan.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.dto.ResponseDto;
import com.pawan.model.Invoice;
import com.pawan.repository.InvoiceRepository;
import com.pawan.utils.Constant;

/**
 * @author pawanthapa
 *
 */

@Service
public class InvoiceServiceImpl {

	private static Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);


	private InvoiceRepository invoiceRepository;

	InvoiceServiceImpl(InvoiceRepository invoiceRepository){
		this.invoiceRepository=invoiceRepository;
	}

	/**
	 * saves the invoice in the repository
	 * 
	 * @param invoice
	 * @author pawanthapa
	 */
	
	public ResponseDto saveInvoice(Invoice invoice) {
		logger.info("Saving invoice started. ");
		String message = validateInvoice(invoice);
		if (!message.isEmpty()) {
			logger.info("Saving invoice failed. ");
			return new ResponseDto(message, 0, 0, null, Constant.BAD_REQUEST);
		} else {
			invoice.setCreatedBy("Pawan Thapa");
			invoice.setModifiedBy("Pawan Thapa");
			invoiceRepository.save(invoice);
			logger.info("Saving invoice successful. ");
			return new ResponseDto("Invoice added successfully. ", 0, 0, invoice, Constant.SUCCESS);
		}

	}

	private String validateInvoice(Invoice invoice) {
		String message = "";
		if (invoice.getCustomerId() <= 0) {
			message += "Customer id cannot be less than or equal to zero, ";
		}
		if (invoice.getInvoiceDate() == null) {
			message += "Invoice date cannot be null, ";
		}
		if (invoice.getInvoiceDueDate() == null) {
			message += "Invoice due date cannot be null, ";
		}
		if (invoice.getInvoiceAmount() == null || invoice.getInvoiceAmount().isEmpty()) {
			message += "Amount cannot be null, empty or zero , ";
		}

		if (message.isEmpty())
			return "";
		else
			return message.substring(0, message.length() - 2);
	}

	/**
	 * fetches the invoice from repository using id and returns it
	 * 
	 * @param invoiceId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto getInvoiceById(int invoiceId) {
		logger.info("Fetching invoice using with id " + invoiceId);
		Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
		if (invoice != null) {
			logger.info("Fetching invoice using with id " + invoiceId + " successful. ");
			return new ResponseDto("Invoice fetched successfully. ", 0, 1, invoice, Constant.SUCCESS);
		} else {
			logger.info("Fetching invoice using with id " + invoiceId + " failed. ");
			return new ResponseDto("Invoice fetch failed. ", 0, 0, null, Constant.FAILED);
		}
	}

	/**
	 * Fetches Invoice List using Customer Id
	 * 
	 * @param customerId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	public ResponseDto getInvoicesByCustomerId(int customerId) {
		logger.info("Fetching list of Invoices using customer id started. ");
		List<Invoice> listOfInvoices = invoiceRepository.findByCustomerId(customerId);
		logger.info("Fetching invoice list using customer id successful. ");
		return new ResponseDto("Fetching invoice list using customer id successful. ", 0, 0, listOfInvoices,
				Constant.SUCCESS);
	}

	/**
	 * returns all the invoices in a list
	 * 
	 * @return List<Invoice>
	 * @author pawanthapa
	 */
	
	public List<Invoice> getAllInvoices() {
		logger.info("Fetching all invoices. ");
		List<Invoice> listOfInvoices = invoiceRepository.findAll();
		logger.info("Fetching invoices successful");
		return listOfInvoices;
	}

	/**
	 * deletes the invoice using id
	 * 
	 * @param invoiceId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	
	public ResponseDto deleteInvoiceById(int invoiceId) {
		logger.info("Deletion with  invoiceId " + invoiceId + " started");
		if (invoiceRepository.findById(invoiceId).orElse(null) == null) {
			logger.info("Invoice does  not exist. ");
			return new ResponseDto("Invoice does not exist. ", 0, 0, null, Constant.FAILED);
		} else {
			logger.info("Invoice found. ");
			invoiceRepository.deleteById(invoiceId);
			logger.info("Deletion of invoiceId " + invoiceId + " done");
			return new ResponseDto("Invoice deleted successfully. ", 0, 0, null, Constant.SUCCESS);
		}
	}

	/**
	 * Fetches Invoice List when status is pending or partially pending
	 * 
	 * @param customerId
	 * @return ResponseDto
	 * @author pawanthapa
	 */
	
	public ResponseDto getInvoiceByIdAndStatus(int customerId) {
		logger.info("fetching invoices by id and status started. ");
		List<String> status = new ArrayList<>();
		status.add("Pending");
		status.add("Partially pending");
		Invoice invoice = invoiceRepository.findByCustomerIdAndStatusIn(customerId, status);
		if (invoice == null) {
			logger.info("fetching invoices by id ans status failed. ");
			return new ResponseDto("Fetching invoice failed. ", 0, 0, null, Constant.FAILED);
		} else {
			logger.info("Fetching invoices by id and status successful. ");
			return new ResponseDto("Fetching invoice successful. ", 0, 0, invoice, Constant.SUCCESS);
		}
	}
	
	/**
	 * fetches the list of distinct customer id
	 * 
	 * @return List<Integer>
	 * @author pawanthapa
	 */
	
	public List<Integer> getAllDistinctCustomerId(){
		logger.info("fetching customer id started. ");
		return invoiceRepository.findDistictCustomers();
	}
}
