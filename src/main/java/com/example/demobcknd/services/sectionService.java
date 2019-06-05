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

    public void addSection(section newSection) {

        sectionrepository.save(newSection);
    }

    public String deleteSection(Long sectionId) {

        sectionrepository.deleteById(sectionId);
        return "deleted";
    }

    public String updateSection(Long id, section newSection) {

        room newroom =  roomrepository.findById(newSection.getNewroom().getRoomId()).get();

        section s = sectionrepository.findById(id).get();
        s.setRows(newSection.getRows());
        s.setSeats(newSection.getSeats());
        s.setNewroom(newroom);
        sectionrepository.save(s);
        return "updated";
    }


}