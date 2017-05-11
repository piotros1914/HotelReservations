package com.piotrowski.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.piotrowski.dao.ReservationDao;
import com.piotrowski.model.Reservation;
import com.piotrowski.model.Room;

@Repository("reservationDao")
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addReservation(Reservation reservation) {
		sessionFactory.getCurrentSession().saveOrUpdate(reservation);
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> listReservations() {
		return (List<Reservation>) sessionFactory.getCurrentSession().createCriteria(Reservation.class).list();
	}

	@Override
	public Reservation getReservation(int id) {
		return (Reservation) sessionFactory.getCurrentSession().get(Reservation.class, id);
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE id = " + reservation.getId())
				.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Reservation> listReservationRoomBeetwenDates(Room room, Date fromDate, Date toDate) {

	//	String hql = "from Reservation where date between :fromDate and :toDate and room = :room";
		String hql = "from Reservation where date >= :fromDate and date <= :toDate and room = :room";

		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);

		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		query.setParameter("room", room);

		List<Reservation> reservations = query.list();

		return reservations;

	}

}