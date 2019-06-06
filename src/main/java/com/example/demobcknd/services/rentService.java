package com.example.demobcknd.services;

import com.example.demobcknd.models.rent;
import com.example.demobcknd.models.customer;
import com.example.demobcknd.models.room;
import com.example.demobcknd.repositories.customerRepository;
import com.example.demobcknd.repositories.rentRepository;
import com.example.demobcknd.repositories.roomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class rentService {
    @Autowired
    private rentRepository rentrepository;

    @Autowired  // epeidh exo pedio customerId (fk)
    private customerRepository custRep;     

    @Autowired  // epeidh exo pedio roomId (fk)
    private roomRepository roomrepository;

    public Iterable<rent> findAllRents() {
        return rentrepository.findAll();
    }

    public rent findRent(Long rentId) {
        return rentrepository.findById(rentId).get();
    }

    public void addRent(rent newRent) {

        rentrepository.save(newRent);
    }

    public void deleteRent(Long rentId) {

        rentrepository.deleteById(rentId);
    }

    public void updateRent(Long id, rent newRent) {

        // customerId, roomId einai apo to rent.java ta referencedColumnName = " "

        customer newcustomer = custRep.findById(newRent.getNewCustomer().getCustomerId()).get();
        room newroom = roomrepository.findById(newRent.getNewRoom().getRoomId()).get();

        newRent.setRentId(id);
        newRent.setNewCustomer(newcustomer); 
        newRent.setNewRoom(newroom); 
        rentrepository.save(newRent);
    }

}