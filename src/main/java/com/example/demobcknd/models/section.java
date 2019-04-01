package com.example.demobcknd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    int rows;
    int seats;

    @ManyToOne   // polla sections exoun 1 room
    @JoinColumn(name = "room_id") // JoinClumn epeidh eberiexete sthn klassi room

    private room newroom;

    public section() {
    }


    public Long getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public room getNewroom() {
        return this.newroom;
    }

    public void setNewroom(room newroom) {
        this.newroom = newroom;
    }

}