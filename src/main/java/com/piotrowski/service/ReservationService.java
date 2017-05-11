package com.piotrowski.service;

import java.util.Date;
import java.util.List;
import com.piotrowski.model.Reservation;
import com.piotrowski.model.Room;
import com.piotrowski.model.form.ReservationForm;

public interface ReservationService {

	public void addReservation(Reservation reservation);
	
	public void addReservation(ReservationForm reservationForm, Room room);

	public List<Reservation> listReservations();

	public Reservation getReservation(int id);

	public void deleteReservation(Reservation reservation);
	
	public  boolean isRoomAvailable( Room room, Date fromDate, Date toDate);
	
}