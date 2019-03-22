package com.example.demobcknd.models;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class theater {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int theaterid;
    private String address;
    private String postalCode;
    private String phone;
    private String mail;


    public theater() {
    }

    public theater(String address, String postalCode, String phone, String mail) {
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.mail = mail;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public theater address(String address) {
        this.address = address;
        return this;
    }

    public theater postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public theater phone(String phone) {
        this.phone = phone;
        return this;
    }

    public theater mail(String mail) {
        this.mail = mail;
        return this;
    }


    public int getTheaterid() {
        return this.theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }



    

}