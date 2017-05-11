package com.piotrowski.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piotrowski.model.Room;
import com.piotrowski.service.ReservationService;
import com.piotrowski.service.RoomService;

@Controller
public class AjaxController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/ajax/dateIsPosible", method = RequestMethod.GET)
	public @ResponseBody String processAJAXRequest(@RequestParam("fromDate") long fromDateLong,
			@RequestParam("toDate") long toDateLong, @RequestParam("roomId") int id) {

		Date fromDate = new Date(fromDateLong);
		Date toDate = new Date(toDateLong);
		Room room = roomService.getRoom(id);

		boolean isRoomAvailable = reservationService.isRoomAvailable(room, fromDate, toDate);

		return createJson("isRoomAvailable", isRoomAvailable);
	}

	private String createJson(String key, boolean value) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(key, value);

		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}

}
