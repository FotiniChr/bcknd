package com.example.demobcknd.models;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    String name;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private room newroom;


    public section() {
    }



    public Long getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public room getNewroom() {
        return this.newroom;
    }

    public void setNewroom(room newroom) {
        this.newroom = newroom;
    }
    




}