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

    public String addRoom(int seats, int _costPerDay) {

        room newroom = new room();
        newroom.setSeats(seats);
        newroom.setCostPerDay(_costPerDay);
        roomrepository.save(newroom);
        return "saved";
    }

    public String deleteRoom(Long roomId) {

        roomrepository.deleteById(roomId);
        return "deleted";
    }

    public String updateRoom(Long roomId, int seats, int _costPerDay) {

        room newroom = roomrepository.findById(roomId).get();
        newroom.setSeats(seats);
        newroom.setCostPerDay(_costPerDay);
        roomrepository.save(newroom);
        return "updated";
    }

}