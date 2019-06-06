package com.example.demobcknd.controllers;

import com.example.demobcknd.models.cast;
import com.example.demobcknd.services.castService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin 
@RequestMapping(path = "/cast", method = { RequestMethod.GET, RequestMethod.POST })
public class castController {
    @Autowired

    castService castservice = new castService();

    @RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCast(@RequestBody cast newCast) {

        castservice.addCast(newCast);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<cast>> getAllCast() {

		Iterable<cast> casts = castservice.findAllCast();
		return new ResponseEntity<Iterable<cast>>(casts, HttpStatus.OK);
	}


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCast(@PathVariable("id") Long id) {

		cast newCast = castservice.findCast(id);
		return new ResponseEntity<cast>(newCast, HttpStatus.OK);
	}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCast(@PathVariable("id") Long id) {

        castservice.deleteCast(id);
		return new ResponseEntity<cast>(HttpStatus.NO_CONTENT);
	}


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCast(@PathVariable("id") Long id, @RequestBody cast newCast) {

        castservice.updateCast(id, newCast);
        newCast.setCastId(id);
		return new ResponseEntity<cast>(newCast, HttpStatus.OK);
	}

}
