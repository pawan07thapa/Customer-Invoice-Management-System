package com.p2s.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.p2s.service.CustomerService;
import com.p2s.service.InvoiceService;

@Controller
public class HomeControllerImpl implements HomeController {

	private static Logger logger = Logger.getLogger(HomeControllerImpl.class);

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private InvoiceService invoiceService;

	/**
	 * This acts as the Home page, all the default requests are directed here All
	 * the data to be displayed in the Home page is added to the ModelAndView object
	 * and returned
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		logger.info("Adding Customer Data to ModelAndView Object");
		mv.setViewName("home.jsp");
		mv.addObject("customers", customerService.getAllCustomer());
		mv.addObject("invoices" , invoiceService.getAllInvoices());
		logger.info(" Customer Data added to ModelAndView Object");
		return mv;
	}
	

}
