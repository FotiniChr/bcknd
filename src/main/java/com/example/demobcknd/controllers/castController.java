package com.example.demobcknd.controllers;

import com.example.demobcknd.models.cast;
import com.example.demobcknd.services.castService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/cast")
public class castController {
    @Autowired

    castService castservice = new castService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewRoom(@RequestParam String direction, @RequestParam String stage_composition,
            @RequestParam String costumes, @RequestParam String stars, @RequestParam String actors) {

        return castservice.addCast(direction, stage_composition, costumes, stars, actors);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<cast> getAllCasts() {

        return castservice.findAllCast();
    }

    @RequestMapping("{id}")
    public @ResponseBody cast getCastId(@PathVariable("id") Long castId) {

        return castservice.findCast(castId);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deleteCastById(@PathVariable("id") Long castId) {

        return castservice.deleteCast(castId);

    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updateCast(@PathVariable("id") Long castid, @RequestParam String direction,
            @RequestParam String stage_composition, @RequestParam String costumes, @RequestParam String stars,
            @RequestParam String actors) {

        return castservice.updateCast(castid, direction, stage_composition, costumes, stars, actors);
    }

}
