package com.example.demobcknd.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // This tells Hibernate to make a table out of this class
public class room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private int seats;
    private int costPerDay;

    // ++ gia to section.java
    @OneToMany(mappedBy = "newroom")
    @JsonIgnore
    private List<section> sections;

    // ++ gia to rent.java
    // @OneToOne(mappedBy = "newRoom")
    // @JsonIgnore
    // private rent _rent;

    @OneToMany(mappedBy = "newRoom")
    @JsonIgnore
    private List<rent> rents;


    public room() {
    }

    // test gia thn main -> na to diagrapso meta
    public room(int seats, int costPerDay) {
        this.seats = seats;
        this.costPerDay = costPerDay;
    }

    public room(int seats, int costPerDay, List<section> sections) {
        this.seats = seats;
        this.costPerDay = costPerDay;
        this.sections = sections;
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

    public int getCostPerDay() {
        return this.costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public room roomId(Long roomId) {
        this.roomId = roomId;
        return this;
    }

    public room seats(int seats) {
        this.seats = seats;
        return this;
    }

    public room costPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " roomId='" + getRoomId() + "'" + ", seats='" + getSeats() + "'" + ", costPerDay='"
                + getCostPerDay() + "'" + "}";
    }

}