package com.piotrowski.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.piotrowski.model.Room;
import com.piotrowski.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;

	@RequestMapping("/")
	public String rooms(Model model) {
		List<Room> listRooms = roomService.listRooms();
		model.addAttribute("roomsList", listRooms);
		return "rooms";
	}
	
	//@RequestMapping("/addRooms")
	public String onlyOneAddRooms(Model model) {
		
		for(int i=0; i<=10; i++){
			Room room1 = new Room();
			Room room2 = new Room();
			Room room3 = new Room();
			Room room4 = new Room();
			
			room1.setFloor(i);
			room2.setFloor(i);
			room3.setFloor(i);
			room4.setFloor(i);
			
			room1.setSizeOfRoomInPersons(1);
			room2.setSizeOfRoomInPersons(2);
			room3.setSizeOfRoomInPersons(3);
			room4.setSizeOfRoomInPersons(4);
			
			room1.setPositionOfWindow("P�noc");
			room2.setPositionOfWindow("Po�udnie");
			room3.setPositionOfWindow("Wsch�d");
			room4.setPositionOfWindow("Zach�d");
			
			room1.setPrice(100 * i);
			room2.setPrice(150 * i);
			room3.setPrice(200 * i);
			room4.setPrice(250 * i);
			
			roomService.addRoom(room1);
			roomService.addRoom(room2);
			roomService.addRoom(room3);
			roomService.addRoom(room4);
	
		}
		List<Room> listRooms = roomService.listRooms();
		model.addAttribute("roomsList", listRooms);
		return "rooms";
	
	}
}