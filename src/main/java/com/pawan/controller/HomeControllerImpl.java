package com.pawan.controller;

import com.pawan.service.CustomerService;
import com.pawan.service.InvoiceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControllerImpl implements HomeController {

	private static Logger logger = LoggerFactory.getLogger(HomeControllerImpl.class);

	private final CustomerService customerService;
	private final InvoiceServiceImpl invoiceService;

	public HomeControllerImpl(CustomerService customerService, InvoiceServiceImpl invoiceService) {
		this.customerService = customerService;
		this.invoiceService = invoiceService;
	}

	/**
	 * This acts as the Home page, all the default requests are directed here All
	 * the data to be displayed in the Home page is added to the ModelAndView object
	 * and returned
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		logger.info("Adding Customer Data to ModelAndView Object");
		mv.setViewName("home");
		mv.addObject("customers", customerService.getAllCustomer());
		mv.addObject("invoices" , invoiceService.getAllInvoices());
		logger.info(" Customer Data added to ModelAndView Object");
		return mv;
	}
	

}


