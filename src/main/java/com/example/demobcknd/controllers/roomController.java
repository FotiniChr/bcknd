package com.example.demobcknd.controllers;

import com.example.demobcknd.models.room;
import com.example.demobcknd.services.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@CrossOrigin 
@RequestMapping(path = "/room", method = { RequestMethod.GET, RequestMethod.POST })
public class roomController {
    @Autowired
    roomService roomservice = new roomService();

    @RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addRoom(@RequestBody room newRoom) {

        roomservice.addRoom(newRoom);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<room>> getAllRooms() {

		Iterable<room> rooms = roomservice.findAllRooms();
		return new ResponseEntity<Iterable<room>>(rooms, HttpStatus.OK);
	}


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRoom(@PathVariable("id") Long id) {
		room newRoom = roomservice.findRoom(id);
		return new ResponseEntity<room>(newRoom, HttpStatus.OK);
	}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id) {

        roomservice.deleteRoom(id);
		return new ResponseEntity<room>(HttpStatus.NO_CONTENT);
	}


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRoom(@PathVariable("id") Long id, @RequestBody room newRoom) {

        roomservice.updateRoom(id, newRoom);
        newRoom.setRoomId(id);
		return new ResponseEntity<room>(newRoom, HttpStatus.OK);
	}

}
