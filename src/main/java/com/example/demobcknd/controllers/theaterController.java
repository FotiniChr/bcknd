package com.example.demobcknd.controllers;

import com.example.demobcknd.models.theater;
import com.example.demobcknd.services.theaterService;
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
@RequestMapping(path = "/theater", method = { RequestMethod.GET, RequestMethod.POST }) 
public class theaterController {

    @Autowired
    theaterService theaterservice = new theaterService();

    @RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addTheater(@RequestBody theater newTheater) {

        theaterservice.addTheater(newTheater);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}


    @RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<Iterable<theater>> getAllTheaters() {
		Iterable<theater> theaters = theaterservice.findAllTheaters();
		return new ResponseEntity<Iterable<theater>>(theaters, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTheater(@PathVariable("id") int id) {
        theater newTheater = theaterservice.findTheater(id);
		return new ResponseEntity<theater>(newTheater, HttpStatus.OK);
	}


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTheater(@PathVariable("id") int id) {

        theaterservice.deleteTheater(id);
		return new ResponseEntity<theater>(HttpStatus.NO_CONTENT);
	}




    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTheater(@PathVariable("id") int id, @RequestBody theater newTheater) {

        theaterservice.updateTheater(id, newTheater);
        newTheater.setTheaterId(id);
		return new ResponseEntity<theater>(newTheater, HttpStatus.OK);
	}



}
