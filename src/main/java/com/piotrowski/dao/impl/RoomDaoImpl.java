package com.piotrowski.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.piotrowski.dao.RoomDao;
import com.piotrowski.model.Room;

@Repository("roomDao")
public class RoomDaoImpl implements RoomDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	public List<Room> listRooms() {
		return (List<Room>) sessionFactory.getCurrentSession().createCriteria(Room.class).list();
	};

	@Override
	public Room getRoom(int id) {
		return (Room) sessionFactory.getCurrentSession().get(Room.class, id);
	}

	@Override
	public void addRoom(Room room) {
		sessionFactory.getCurrentSession().saveOrUpdate(room);	
	}
}