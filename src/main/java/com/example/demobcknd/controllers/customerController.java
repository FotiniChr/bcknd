package com.example.demobcknd.controllers;

import com.example.demobcknd.models.customer;
import com.example.demobcknd.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/customer")
public class customerController {
    @Autowired

    customerService customerservice = new customerService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewCustomer(@RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String email, @RequestParam String phone, @RequestParam String address,
            @RequestParam String postalCode) {

        return customerservice.addCustomer(firstName, lastName, email, phone, address, postalCode);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<customer> getAllCustomer() {

        return customerservice.findAllCustomers();

    }

    @RequestMapping("{id}")
    public @ResponseBody customer getCustomerById(@PathVariable("id") Long id) {

        return customerservice.findCustomer(id);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deleteCustomerById(@PathVariable("id") Long id) {

        return customerservice.deleteCustomer(id);

    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updateCustomer(
            @PathVariable("id") long id, @RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String email, @RequestParam String phone, @RequestParam String address,
            @RequestParam String postalCode
    ) {

        return customerservice.updateCustomer(id, firstName, lastName, email, phone, address, postalCode);
    }

}