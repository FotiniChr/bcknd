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

    public void addCustomer( customer newCustomer) {

        custRep.save(newCustomer);
    }

    public void deleteCustomer(long customerId) {
        custRep.deleteById(customerId);
    }
    
    public void updateCustomer(long id, customer newCustomer ) {
        // customer u = custRep.findById(id).get();
        // u.setFirstName(firstName);
        // u.setLastName(lastName);
        // u.setEmail(email);
        // u.setPhone(phone);
        // u.setAddress(address);
        // u.setPostalCode(postalCode);
        newCustomer.setCustomerId(id);
        custRep.save(newCustomer);
    }

}