package com.example.demobcknd.services;

import com.example.demobcknd.models.room;
import com.example.demobcknd.models.section;
import com.example.demobcknd.repositories.roomRepository;
import com.example.demobcknd.repositories.sectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sectionService {
    @Autowired 
    private sectionRepository sectionrepository;    

    @Autowired 
    private roomRepository roomrepository;


    public Iterable<section> findAllSections() {

        return sectionrepository.findAll();

    }

    public section findSection(Long sectionId) {

        return sectionrepository.findById(sectionId).get();
    }

    public String addSection(Long roomId, int rows, int seats) {
        
        room newroom =  roomrepository.findById(roomId).get();

        section newsection = new section();
        newsection.setNewroom(newroom);
        newsection.setRows(rows);
        newsection.setSeats(seats);
        sectionrepository.save(newsection);
        return "saved";

    }

    public String deleteSection(Long sectionId) {

        sectionrepository.deleteById(sectionId);
        return "deleted";
    }

    public String updateSection(Long sectionId, Long roomId, int rows, int seats) {

        room newroom =  roomrepository.findById(roomId).get();

        section newsection = sectionrepository.findById(sectionId).get();
        newsection.setRows(rows);
        newsection.setSeats(seats);
        newsection.setNewroom(newroom);
        sectionrepository.save(newsection);
        return "updated";
    }

}