package com.piotrowski.service;

import java.util.List;

import com.piotrowski.model.Room;

public interface RoomService {
	
	public void addRoom(Room room);

	public List<Room> listRooms();

	public Room getRoom(int id);

}