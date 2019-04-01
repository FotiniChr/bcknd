package com.example.demobcknd.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity // This tells Hibernate to make a table out of this class
public class room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private int seats;

    @OneToMany(mappedBy = "newroom")  // "newroom" eiani to pedio opos to exo 
                    // orisei sthn klassi section
    private List<section> sections;

    public room() {
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public List<section> getSections() {
        return this.sections;
    }

    public void setSections(List<section> sections) {
        this.sections = sections;
    }

}