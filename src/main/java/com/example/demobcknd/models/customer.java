package com.example.demobcknd.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String postalCode;

    // ++ gia to rent.java
    // @OneToOne(mappedBy = "newCustomer")
    // @JsonIgnore
    // private rent _rent;

    @OneToMany(mappedBy = "newCustomer")
    @JsonIgnore
    private List<rent> rents;

    public customer() {
    }

    public customer( String firstName, String lastName, String email, String phone, String address,
            String postalCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postalCode = postalCode;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public customer customerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public customer firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public customer lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public customer email(String email) {
        this.email = email;
        return this;
    }

    public customer phone(String phone) {
        this.phone = phone;
        return this;
    }

    public customer address(String address) {
        this.address = address;
        return this;
    }

    public customer postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " customerId='" + getCustomerId() + "'" + ", firstName='" + getFirstName() + "'" + ", lastName='"
                + getLastName() + "'" + ", email='" + getEmail() + "'" + ", phone='" + getPhone() + "'" + ", address='"
                + getAddress() + "'" + ", postalCode='" + getPostalCode() + "'" + "}";
    }

}