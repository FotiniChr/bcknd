package com.example.demobcknd.controllers;

import com.example.demobcknd.models.customer;
import com.example.demobcknd.services.customerService;
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
@RequestMapping(path = "/customer", method = { RequestMethod.GET, RequestMethod.POST })
public class customerController {
    @Autowired

    customerService customerservice = new customerService();

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody customer newCustomer) {

        customerservice.addCustomer(newCustomer);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<customer>> getAllCustomers() {

        Iterable<customer> customers = customerservice.findAllCustomers();
        return new ResponseEntity<Iterable<customer>>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PathVariable("id") Long id) {

        customer newCustomer = customerservice.findCustomer(id);
        return new ResponseEntity<customer>(newCustomer, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSection(@PathVariable("id") Long id) {

        customerservice.deleteCustomer(id);
        return new ResponseEntity<customer>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody customer newCustomer) {

        customerservice.updateCustomer(id, newCustomer);
        newCustomer.setCustomerId(id);
		return new ResponseEntity<customer>(newCustomer, HttpStatus.OK);
	}

}
