package com.piotrowski.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.piotrowski.model.Customer;
import com.piotrowski.service.CustomerService;

@Controller
@RequestMapping(value = "/staffs")
public class StaffController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String reservationForm(Model model) {
		return "forStaff";
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String customers(Model model) {
		List<Customer> customers = customerService.listCustomers();
		model.addAttribute("customerList", customers);
		return "customers";
	}
}
