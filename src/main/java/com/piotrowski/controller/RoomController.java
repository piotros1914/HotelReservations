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
	
	@RequestMapping("/addRooms")
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
			
			room1.setPositionOfWindow("Północ");
			room2.setPositionOfWindow("Południe");
			room3.setPositionOfWindow("Wschód");
			room4.setPositionOfWindow("Zachód");
			
			room1.setPrice(100 * i + 100);
			room2.setPrice(150 * i + 100);
			room3.setPrice(200 * i + 100);
			room4.setPrice(250 * i + 100);
			
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
