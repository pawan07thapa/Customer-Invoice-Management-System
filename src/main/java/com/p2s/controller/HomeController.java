package com.p2s.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface HomeController {

	/**
	 * This acts as the Home page, all the default requests are directed here All
	 * the data to be displayed in the home page is added to the ModelAndView object
	 * and returned
	 * 
	 * @return ModelAndView
	 * @author pawanthapa
	 */
	@RequestMapping("/")
	public ModelAndView home();

}
