package com.example.demobcknd.controllers;

import com.example.demobcknd.models.performancePrice;
import com.example.demobcknd.services.performancePriceService;

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
@RequestMapping(path = "/performanceprice", method = { RequestMethod.GET, RequestMethod.POST })

public class performancePriceController {
    @Autowired
    performancePriceService performancePriceservice = new performancePriceService();

   
    @RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addPerformancePrice(@RequestBody performancePrice newPerformancePrice) {

        performancePriceservice.addPerformancePrice(newPerformancePrice);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<performancePrice>> getAllPerformancePrices() {

		Iterable<performancePrice> performancePrices = performancePriceservice.findAllPerformancePrices();
		return new ResponseEntity<Iterable<performancePrice>>(performancePrices, HttpStatus.OK);
	}


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPerformancePrice(@PathVariable("id") Long id) {
        performancePrice newPerformancePrice = performancePriceservice.findPerformancePrice(id);
		return new ResponseEntity<performancePrice>(newPerformancePrice, HttpStatus.OK);
	}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePerformancePrice(@PathVariable("id") Long id) {

        performancePriceservice.deletePerformancePrice(id);
		return new ResponseEntity<performancePrice>(HttpStatus.NO_CONTENT);
	}


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePerformancePrice(@PathVariable("id") Long id, @RequestBody performancePrice newPerformancePrice) {

        performancePriceservice.updatePerformancePrice(id, newPerformancePrice);
        newPerformancePrice.setPerformancePriceId(id);
		return new ResponseEntity<performancePrice>(newPerformancePrice, HttpStatus.OK);
	}


}
