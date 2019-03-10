package com.example.demobcknd.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class test {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstname;

    private String lastname;

    public test() {
    }

    public test(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public test id(Integer id) {
        this.id = id;
        return this;
    }

    public test firstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public test lastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    


}