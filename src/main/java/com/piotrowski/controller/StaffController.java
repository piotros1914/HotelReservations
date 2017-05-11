package com.piotrowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/staffs")
public class StaffController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String reservationForm(Model model) {
	
		return "staff";
	}
}