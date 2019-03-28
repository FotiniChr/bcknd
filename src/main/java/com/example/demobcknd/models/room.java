package com.example.demobcknd.models;

import java.util.List;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String name;
    
    @OneToMany(mappedBy = "newroom")
    private List<section> sections;


    public room() {
    }



    public Long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<section> getSections() {
        return this.sections;
    }

    public void setSections(List<section> sections) {
        this.sections = sections;
    }
    



}