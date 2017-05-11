package com.piotrowski.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.piotrowski.model.Room;
import com.piotrowski.model.form.ReservationForm;
import com.piotrowski.model.validator.ReservationFormValidator;
import com.piotrowski.service.ReservationService;
import com.piotrowski.service.RoomService;

@Controller
public class ReservationController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationFormValidator reservationFormValidator;


	@RequestMapping(value = "/reservation/{roomId}", method = RequestMethod.GET)
	public String reservationForm(@PathVariable int roomId, Model model) {
		Room room = roomService.getRoom(roomId);
		model.addAttribute("reservationForm", new ReservationForm());
		model.addAttribute("room", room);
		return "reservationForm";
	}

	@RequestMapping(value = "/reservation/{roomId}", method = RequestMethod.POST)
	public String reservationSubmit(@PathVariable int roomId, @ModelAttribute("reservationForm") @Valid ReservationForm reservationForm,
			 BindingResult bindingResult, Model model) {
		
		Room room = roomService.getRoom(roomId);
		model.addAttribute("room", room);
		reservationFormValidator.setRoom(room);
		reservationFormValidator.validate(reservationForm, bindingResult);
		
		if (!bindingResult.hasErrors()) {
			reservationService.addReservation(reservationForm, room);
			model.addAttribute("reservationForm", reservationForm);
		
            return "reservationSubmit";
        }
		
		return "reservationForm";
	}
	
	@InitBinder()
	public void initBinder(WebDataBinder binder) {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
