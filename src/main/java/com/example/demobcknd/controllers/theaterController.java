package com.example.demobcknd.controllers;

import com.example.demobcknd.models.theater;
import com.example.demobcknd.services.theaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/theater")
public class theaterController {
    @Autowired

    theaterService theaterservice = new theaterService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser(@RequestParam String address, @RequestParam String postalcode,
            @RequestParam String phone, @RequestParam String mail) {
        return theaterservice.addTheater(address, postalcode, phone, mail);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<theater> getAllTheaters() {
        return theaterservice.findAll();
    }

    @RequestMapping("{id}")
    public @ResponseBody theater getTheaterId(@PathVariable("id") int id) {
        return theaterservice.findTheater(id);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deleteTheaterID(@PathVariable("id") int id) {

        return theaterservice.deleteTheater(id);
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updateTheater(@PathVariable("id") int id, @RequestParam String address,@RequestParam String postalcode,
            @RequestParam String phone, @RequestParam String mail) {
        return theaterservice.updateTheater(id, address, postalcode, phone, mail);
    }

}
