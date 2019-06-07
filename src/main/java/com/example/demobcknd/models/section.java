package com.example.demobcknd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // This tells Hibernate to make a table out of this class
public class section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    @Column(name = "\"rows\"")
    private int rows;
    private int seats;

    // pedio room_id -FK-
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "roomId")
    private room newroom;

    // ++ gia to performancePrice.java
    @OneToOne(mappedBy = "newSection")
    @JsonIgnore
    private performancePrice _perfPrice;

    public section() {
    }

    public Long getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }


    public int getColumns() {
        return this.rows;
    }

    public void setColumns(int rows) {
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