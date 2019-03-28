package com.example.demobcknd.services;

import com.example.demobcknd.models.room;
import com.example.demobcknd.repositories.roomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class roomService {
    @Autowired 
    private roomRepository roomrepository;

    public Iterable<room> findAllRooms() {

        return roomrepository.findAll();

    }

    public room findRoom(Long id) {

        return roomrepository.findById(id).get();
    }

    public String addRoom(String name) {

        room newroom = new room();
        newroom.setName(name);
        roomrepository.save(newroom);
        return "saved";

    }

    public String deleteRoom(Long id) {

        roomrepository.deleteById(id);
        return "deleted";
    }

    public String updateRoom(Long id, String name) {

        room newroom = roomrepository.findById(id).get();
        newroom.setName(name);
        roomrepository.save(newroom);
        return "updated";
    }

}