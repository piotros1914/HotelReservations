package com.piotrowski.dao;

import java.util.Date;
import java.util.List;
import com.piotrowski.model.Reservation;
import com.piotrowski.model.Room;

public interface ReservationDao {

	public void addReservation(Reservation reservation);

	public List<Reservation> listReservations();

	public Reservation getReservation(int id);

	public void deleteReservation(Reservation reservation);
	
	public List<Reservation> listReservationRoomBeetwenDates(Room room, Date fromDate, Date toDate);
}