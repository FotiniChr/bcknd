package com.example.demobcknd.controllers;

import com.example.demobcknd.models.section;
import com.example.demobcknd.services.sectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/section")
public class sectionController {
    @Autowired

    sectionService sectionservice = new sectionService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewSection(@RequestParam Long roomid,
            @RequestParam int rows, @RequestParam int seats) {

        return sectionservice.addSection(roomid, rows, seats);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<section> getAllSections() {

        return sectionservice.findAllSections();

    }

    @RequestMapping("{id}")
    public @ResponseBody section getSectionById(@PathVariable("id") Long id) {

        return sectionservice.findSection(id);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deleteSectionById(@PathVariable("id") Long id) {

        return sectionservice.deleteSection(id);
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updateSection(@PathVariable("id") Long id, @RequestParam int rows,
            @RequestParam int seats, @RequestParam Long roomid) {

        return sectionservice.updateSection(id, roomid, rows, seats);

    }

}
