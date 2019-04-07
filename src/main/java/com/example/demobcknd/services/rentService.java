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

    public String addRent(Long customerId, Long roomId, String date, int period) {

        customer newcustomer = custRep.findById(customerId).get();
        room newroom = roomrepository.findById(roomId).get();

        rent newrent = new rent();
        newrent.setNewCustomer(newcustomer);
        newrent.setNewRoom(newroom);
        newrent.setDate(date);
        newrent.setPeriod(period);
        rentrepository.save(newrent);
        return "saved";
    }

    public String deleteRent(Long rentId) {

        rentrepository.deleteById(rentId);
        return "deleted";
    }

    public String updateRent(Long rentId, Long customerId, Long roomId, String date, int period) {

        // customerId, roomId einai apo to rent.java ta referencedColumnName = " "

        customer newcustomer = custRep.findById(customerId).get();
        room newroom = roomrepository.findById(roomId).get();

        rent newrent = rentrepository.findById(rentId).get();
        newrent.setNewCustomer(newcustomer); // customer newcustomer = custRep.findById(customerId).get();
        newrent.setNewRoom(newroom); // room newroom = roomrepository.findById(roomId).get();
        newrent.setDate(date);
        newrent.setPeriod(period);
        rentrepository.save(newrent);
        return "updated";
    }

}