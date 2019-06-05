package com.example.demobcknd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentId;

    // pedio customer_id   -FK-
    // @OneToOne
    // @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    // private customer newCustomer;

    // pedio room_id       -FK-
    // @OneToOne
    // @JoinColumn(name = "room_id", referencedColumnName = "roomId")
    // private room newRoom;

  
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private customer newCustomer;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "roomId")
    private room newRoom;

    private String date;
    private int period;   // 1,2,3,4


    public rent() {
    }

    public rent(customer newCustomer, room newRoom, String date, int period) {
        // this.rentId = rentId;
        this.newCustomer = newCustomer;
        this.newRoom = newRoom;
        this.date = date;
        this.period = period;
    }

    public Long getRentId() {
        return this.rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }

    public customer getNewCustomer() {
        return this.newCustomer;
    }

    public void setNewCustomer(customer newCustomer) {
        this.newCustomer = newCustomer;
    }

    public room getNewRoom() {
        return this.newRoom;
    }

    public void setNewRoom(room newRoom) {
        this.newRoom = newRoom;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "{" + " rentId='" + getRentId() + "'" + ", newCustomer='" + getNewCustomer() + "'" + ", newRoom='"
                + getNewRoom() + "'" + ", date='" + getDate() + "'" + ", period='" + getPeriod() + "'" + "}";
    }

}