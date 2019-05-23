package com.example.demobcknd.controllers;

import com.example.demobcknd.models.room;
import com.example.demobcknd.services.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin 
@RequestMapping(path = "/room")
public class roomController {
    @Autowired

    roomService roomservice = new roomService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewRoom(@RequestParam int seats, @RequestParam int costperday) {

        return roomservice.addRoom(seats, costperday);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<room> getAllRooms() {

        return roomservice.findAllRooms();

    }

    @RequestMapping("{id}")
    public @ResponseBody room getRoomById(@PathVariable("id") Long id) {

        return roomservice.findRoom(id);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deleteRoomById(@PathVariable("id") Long id) {

        return roomservice.deleteRoom(id);

    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updateRoom(@PathVariable("id") Long id, @RequestParam int seats,
            @RequestParam int costperday) {

        return roomservice.updateRoom(id, seats, costperday);
    }

}
