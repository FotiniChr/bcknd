package com.example.demobcknd.controllers;

import com.example.demobcknd.models.rent;
import com.example.demobcknd.services.rentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/rent")
public class rentController {
    @Autowired
    rentService rentservice = new rentService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewSection(@RequestParam Long customerId, @RequestParam Long roomId,
            @RequestParam String date, @RequestParam int period) {

        return rentservice.addRent(customerId, roomId, date, period);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<rent> getAllRents() {

        return rentservice.findAllRents();

    }

    @RequestMapping("{id}")
    public @ResponseBody rent getRentById(@PathVariable("id") Long rentId) {

        return rentservice.findRent(rentId);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deleteRentById(@PathVariable("id") Long rentId) {

        return rentservice.deleteRent(rentId);
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updateRent(@PathVariable("id") Long id,@RequestParam Long customerId, @RequestParam Long roomId,
    @RequestParam String date, @RequestParam int period) {

        return rentservice.updateRent(id, customerId, roomId, date, period);

    }

}
