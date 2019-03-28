package com.example.demobcknd.services;

import com.example.demobcknd.models.room;
import com.example.demobcknd.models.section;
import com.example.demobcknd.models.user;
import com.example.demobcknd.repositories.roomRepository;
import com.example.demobcknd.repositories.sectionRepository;
import com.example.demobcknd.repositories.userRepository;

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

    public section findSection(Long id) {

        return sectionrepository.findById(id).get();
    }

    public String addSection(String name, Long roomId) {
        
        room newroom =  roomrepository.findById(roomId).get();
        section newsection = new section();
        newsection.setName(name);
        newsection.setNewroom(newroom);
        sectionrepository.save(newsection);
        return "saved";

    }

    public String deleteSection(Long id) {

        sectionrepository.deleteById(id);
        return "deleted";
    }

    public String updateSection(Long id, String name, Long roomId) {

        room newroom =  roomrepository.findById(roomId).get();

        section newsection = sectionrepository.findById(id).get();
        newsection.setName(name);
        newsection.setNewroom(newroom);
        sectionrepository.save(newsection);
        return "updated";
    }

}