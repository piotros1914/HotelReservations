package com.piotrowski.model.validator;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.piotrowski.model.Room;
import com.piotrowski.model.form.ReservationForm;
import com.piotrowski.service.ReservationService;


@Component
public class ReservationFormValidator implements Validator {

	
	@Autowired
	private ReservationService reservationService;
	
	Room room;
	
	@Override
	public boolean supports(Class<?> classObject) {
		 return ReservationForm.class.equals(classObject);
	}

	@Override
	public void validate(Object object, Errors error) {
		ReservationForm reservationForm = (ReservationForm) object;
		String firstName = reservationForm.getFirstName();
		
		Date fromDate = reservationForm.getFromDate();
		Date toDate = reservationForm.getToDate();
		
		boolean isRoomAvailable = reservationService.isRoomAvailable(room, fromDate, toDate);
		
		if(!isRoomAvailable){
			
			error.rejectValue("fromDate", "reservationForm.date.available");
			error.rejectValue("toDate", "reservationForm.date.available");
		}
		
        if (firstName.equals("dupa")) {
        	error.rejectValue("firstName", "reservationForm.firstName.dupa");
        	System.out.println(error);
        } 
		
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	

}
