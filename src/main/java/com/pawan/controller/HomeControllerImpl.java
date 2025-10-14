package com.pawan.controller;

import com.pawan.service.CustomerService;
import com.pawan.service.InvoiceServiceImpl;
import com.pawan.service.PaymentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControllerImpl implements HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeControllerImpl.class);

	private final CustomerService customerService;
	private final InvoiceServiceImpl invoiceService;
	private final PaymentServiceImpl paymentService;

	public HomeControllerImpl(CustomerService customerService, 
	                          InvoiceServiceImpl invoiceService,
	                          PaymentServiceImpl paymentService) {
		this.customerService = customerService;
		this.invoiceService = invoiceService;
		this.paymentService = paymentService;
	}

	/**
	 * Home page with dashboard statistics and quick search
	 * All the data to be displayed in the Home page is added to the ModelAndView object
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@Override
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		logger.info("Loading home page with dashboard data");
		mv.setViewName("home");
		mv.addObject("customers", customerService.getAllCustomer());
		mv.addObject("invoices", invoiceService.getAllInvoices());
		mv.addObject("payments", paymentService.getAllPayments());
		logger.info("Home page data loaded successfully");
		return mv;
	}
	

}


