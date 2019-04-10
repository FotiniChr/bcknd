package com.example.demobcknd.services;

import com.example.demobcknd.models.customer;
import com.example.demobcknd.repositories.customerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerService {
    @Autowired 
    private customerRepository custRep;

    public Iterable<customer> findAllCustomers() {
        return custRep.findAll();

    }

    public customer findCustomer(long customerId) {
        return custRep.findById(customerId).get();
    }

    public String addCustomer( String firstName, String lastName, String email,
    String phone, String address, String postalCode) {
        customer u = new customer();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setPhone(phone);
        u.setAddress(address);
        u.setPostalCode(postalCode);
        custRep.save(u);
        return "Saved";
    }

    public String deleteCustomer(long customerId) {
        custRep.deleteById(customerId);
        return "deleted";
    }
    
    public String updateCustomer(long customerId, String firstName, String lastName, String email,
    String phone, String address, String postalCode ) {
        customer u = custRep.findById(customerId).get();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setPhone(phone);
        u.setAddress(address);
        u.setPostalCode(postalCode);
        custRep.save(u);
        return "updated";
    }

}