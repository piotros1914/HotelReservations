package com.piotrowski.dao;

import java.util.List;
import com.piotrowski.model.Room;


public interface RoomDao {
	
	public void addRoom(Room room);

	public List<Room> listRooms();

	public Room getRoom(int id);

}