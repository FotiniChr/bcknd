package com.example.demobcknd.controllers;

import com.example.demobcknd.models.section;
import com.example.demobcknd.services.sectionService;
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
@RequestMapping(path = "/section", method = { RequestMethod.GET, RequestMethod.POST })
public class sectionController {
    @Autowired
    sectionService sectionservice = new sectionService();


    @RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addSection(@RequestBody section newSection) {

        sectionservice.addSection(newSection);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<section>> getAllSections() {

		Iterable<section> sections = sectionservice.findAllSections();
		return new ResponseEntity<Iterable<section>>(sections, HttpStatus.OK);
	}


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSection(@PathVariable("id") Long id) {
		section newSection = sectionservice.findSection(id);
		return new ResponseEntity<section>(newSection, HttpStatus.OK);
	}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteSection(@PathVariable("id") Long id) {

        sectionservice.deleteSection(id);
		return new ResponseEntity<section>(HttpStatus.NO_CONTENT);
	}


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSection(@PathVariable("id") Long id, @RequestBody section newSection) {

        sectionservice.updateSection(id, newSection);
        newSection.setSectionId(id);
		return new ResponseEntity<section>(newSection, HttpStatus.OK);
	}



}
