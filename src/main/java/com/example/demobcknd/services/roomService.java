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

    public void deleteRoom(Long roomId) {

        roomrepository.deleteById(roomId);
    }

    public void updateRoom(Long id, room newRoom) {

        newRoom.setRoomId(id);
        roomrepository.save(newRoom);
    }

}