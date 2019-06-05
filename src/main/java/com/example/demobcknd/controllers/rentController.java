package com.example.demobcknd.controllers;

import com.example.demobcknd.models.rent;
import com.example.demobcknd.services.rentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin 
@RequestMapping(path = "/rent", method = { RequestMethod.GET, RequestMethod.POST })
public class rentController {
    @Autowired
    rentService rentservice = new rentService();

    @RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addRent(@RequestBody rent newRent) {

        rentservice.addRent(newRent);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<rent>> getAllRent() {

		Iterable<rent> rents = rentservice.findAllRents();
		return new ResponseEntity<Iterable<rent>>(rents, HttpStatus.OK);
	}


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRent(@PathVariable("id") Long id) {

		rent newRent = rentservice.findRent(id);
		return new ResponseEntity<rent>(newRent, HttpStatus.OK);
	}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRent(@PathVariable("id") Long id) {

        rentservice.deleteRent(id);
		return new ResponseEntity<rent>(HttpStatus.NO_CONTENT);
	}


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRent(@PathVariable("id") Long id, @RequestBody rent newRent) {

        rentservice.updateRent(id,newRent);
        newRent.setRentId(id);

		return new ResponseEntity<rent>(newRent, HttpStatus.OK);
	}


}
