package com.example.demobcknd.controllers;

import com.example.demobcknd.models.rent;
import com.example.demobcknd.services.rentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin 
@RequestMapping(path = "/rent")
public class rentController {
    @Autowired
    rentService rentservice = new rentService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewSection(@RequestParam Long customerid, @RequestParam Long roomid,
            @RequestParam String date, @RequestParam int period) {

        return rentservice.addRent(customerid, roomid, date, period);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<rent> getAllRents() {

        return rentservice.findAllRents();

    }

    @RequestMapping("{id}")
    public @ResponseBody rent getRentById(@PathVariable("id") Long rentid) {

        return rentservice.findRent(rentid);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deleteRentById(@PathVariable("id") Long rentid) {

        return rentservice.deleteRent(rentid);
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updateRent(@PathVariable("id") Long id,@RequestParam Long customerid, @RequestParam Long roomid,
    @RequestParam String date, @RequestParam int period) {

        return rentservice.updateRent(id, customerid, roomid, date, period);

    }

}
