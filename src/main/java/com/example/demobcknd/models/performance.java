package com.example.demobcknd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performanceId;

    private String name;

    
    // pedio cast_id -FK-
    @OneToOne
    @JoinColumn(name = "cast_id", referencedColumnName = "CastId")
    private cast newCast;

    private String date;
    private String start_time;
    private int duration;


    public performance() {
    }

    public performance(String name, cast newCast, String date, String start_time, int duration) {
        this.name = name;
        this.newCast = newCast;
        this.date = date;
        this.start_time = start_time;
        this.duration = duration;
    }

    public Long getPerformanceId() {
        return this.performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public cast getNewCast() {
        return this.newCast;
    }

    public void setNewCast(cast newCast) {
        this.newCast = newCast;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return this.start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public performance performanceId(Long performanceId) {
        this.performanceId = performanceId;
        return this;
    }

    public performance name(String name) {
        this.name = name;
        return this;
    }

    public performance newCast(cast newCast) {
        this.newCast = newCast;
        return this;
    }

    public performance date(String date) {
        this.date = date;
        return this;
    }

    public performance start_time(String start_time) {
        this.start_time = start_time;
        return this;
    }

    public performance duration(int duration) {
        this.duration = duration;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " performanceId='" + getPerformanceId() + "'" +
            ", name='" + getName() + "'" +
            ", newCast='" + getNewCast() + "'" +
            ", date='" + getDate() + "'" +
            ", start_time='" + getStart_time() + "'" +
            ", duration='" + getDuration() + "'" +
            "}";
    }



}