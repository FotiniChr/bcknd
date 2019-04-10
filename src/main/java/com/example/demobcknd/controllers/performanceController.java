package com.example.demobcknd.controllers;

import com.example.demobcknd.models.performance;
import com.example.demobcknd.services.performanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/performance")
public class performanceController {
    @Autowired
    performanceService performanceservice = new performanceService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewPerformance(@RequestParam String name,
    @RequestParam long newcast, @RequestParam String date, @RequestParam String start_time,
    @RequestParam int duration) {

        return performanceservice.addPerformance(name, newcast, date, start_time, duration);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<performance> getAllPerformances() {

        return performanceservice.findAllPerformances();

    }

    @RequestMapping("{id}")
    public @ResponseBody performance getPerformanceById(@PathVariable("id") Long performanceId) {

        return performanceservice.findPerformance(performanceId);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deletePerformanceById(@PathVariable("id") Long performanceId) {

        return performanceservice.deletePerformance(performanceId);
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updatePerformance(@PathVariable("id") Long performanceid, @RequestParam String name,
            @RequestParam long newcast, @RequestParam String date, @RequestParam String start_time,
            @RequestParam int duration) {

        return performanceservice.updatePerformance(performanceid, name, newcast, date, start_time, duration);

    }

}
