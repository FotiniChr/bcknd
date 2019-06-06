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

    public void deleteSection(Long sectionId) {

        sectionrepository.deleteById(sectionId);
    }

    public void updateSection(Long id, section newSection) {

        room newroom =  roomrepository.findById(newSection.getNewroom().getRoomId()).get();

        newSection.setSectionId(id);
        newSection.setNewroom(newroom);
        sectionrepository.save(newSection);
    }


}