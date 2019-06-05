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

    public room findRoom(Long roomId) {
        return roomrepository.findById(roomId).get();
    }

    public void addRoom(room newRoom) {

        roomrepository.save(newRoom);
    }

    public String deleteRoom(Long roomId) {

        roomrepository.deleteById(roomId);
        return "deleted";
    }

    public String updateRoom(Long id, room newRoom) {

        room r = roomrepository.findById(id).get();
        r.setSeats(newRoom.getSeats());
        r.setCostPerDay(newRoom.getCostPerDay());
        roomrepository.save(r);
        return "updated";
    }

}