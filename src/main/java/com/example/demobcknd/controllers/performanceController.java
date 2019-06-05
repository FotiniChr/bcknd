package com.example.demobcknd.controllers;

import com.example.demobcknd.models.performance;
import com.example.demobcknd.services.performanceService;
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
@RequestMapping(path = "/performance", method = { RequestMethod.GET, RequestMethod.POST })
public class performanceController {
    @Autowired
    performanceService performanceservice = new performanceService();

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addPerformance(@RequestBody performance newPerformance) {

        performanceservice.addPerformance(newPerformance);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<performance>> getAllPerformances() {

        Iterable<performance> performances = performanceservice.findAllPerformances();
        return new ResponseEntity<Iterable<performance>>(performances, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPerformance(@PathVariable("id") Long id) {

        performance newPerformance = performanceservice.findPerformance(id);

        return new ResponseEntity<performance>(newPerformance, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerformance(@PathVariable("id") Long id) {

        performanceservice.deletePerformance(id);
        return new ResponseEntity<performance>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerformance(@PathVariable("id") Long id, @RequestBody performance newPerformance) {


        performanceservice.updatePerformance(id, newPerformance);
        newPerformance.setPerformanceId(id);
        return new ResponseEntity<performance>(newPerformance, HttpStatus.OK);
    }

}
