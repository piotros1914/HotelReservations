package com.piotrowski.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.piotrowski.dao.RoomDao;
import com.piotrowski.model.Room;
import com.piotrowski.service.RoomService;

@Service("roomService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRoom(Room room) {
		roomDao.addRoom(room);
	}

	@Override
	public List<Room> listRooms() {
		return roomDao.listRooms();
	}

	@Override
	public Room getRoom(int id) {
		return roomDao.getRoom(id);
	}

}
