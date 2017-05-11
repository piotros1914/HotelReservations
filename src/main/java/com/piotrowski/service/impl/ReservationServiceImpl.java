package com.piotrowski.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.piotrowski.dao.CustomerDao;
import com.piotrowski.dao.ReservationDao;
import com.piotrowski.helper.DateHelper;
import com.piotrowski.model.Customer;
import com.piotrowski.model.Reservation;
import com.piotrowski.model.Room;
import com.piotrowski.model.form.ReservationForm;
import com.piotrowski.service.ReservationService;

@Service("reservationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private CustomerDao customerDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addReservation(Reservation reservation) {
		reservationDao.addReservation(reservation);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addReservation(ReservationForm reservationForm, Room room) {
		
		Date fromDate = reservationForm.getFromDate();
		Date toDate = reservationForm.getToDate();
		List<Date> breakfastList = reservationForm.getBreakfastList();
		
		Customer customer = reservationForm.getCustomer();
		Customer customerWithID = customerDao.addCustomerAndReturnWithId(customer);
		
		int numberOfDays = DateHelper.differenceInDay(fromDate, toDate);
		for(int i = 0; i<=numberOfDays; i++){
			Date dayOfStay = DateHelper.getDateAfterDays(fromDate, i);
			
			Reservation reservation = new Reservation();
			reservation.setCustomer(customerWithID);
			reservation.setRoom(room);
			reservation.setDate(dayOfStay);
			
			if(breakfastList.contains(dayOfStay))
				reservation.setBreakfast(true);
			else
				reservation.setBreakfast(false);
			
			reservationDao.addReservation(reservation);
		}
	}

	@Override
	public List<Reservation> listReservations() {
		return reservationDao.listReservations();
	}

	@Override
	public Reservation getReservation(int id) {
		return reservationDao.getReservation(id);
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		reservationDao.deleteReservation(reservation);
	}
	@Override
	public boolean isRoomAvailable(Room room, Date fromDate, Date toDate ) {
		List<Reservation> reservationList =  reservationDao.listReservationRoomBeetwenDates(room, fromDate, toDate);
		System.out.println(reservationList.size());
		return reservationList.isEmpty();
	}
}
