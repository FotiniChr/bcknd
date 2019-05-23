package com.example.demobcknd.controllers;

import com.example.demobcknd.models.performancePrice;
import com.example.demobcknd.services.performancePriceService;
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
@RequestMapping(path = "/performanceprice")
public class performancePriceController {
    @Autowired
    performancePriceService ppeservice = new performancePriceService();

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String addNewPerformancePrice(@RequestParam long newPerformance, @RequestParam long newSection,
            @RequestParam float ticketPrice) {

        return ppeservice.addPerformancePrice(newPerformance, newSection, ticketPrice);

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<performancePrice> getAllPerformancePrices() {

        return ppeservice.findAllPerformancePrices();

    }

    @RequestMapping("{id}")
    public @ResponseBody performancePrice getPerformancePriceById(@PathVariable("id") Long performancePriceId) {

        return ppeservice.findPerformancePrice(performancePriceId);

    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String deletePerformancePriceById(@PathVariable("id") Long performancePriceId) {

        return ppeservice.deletePerformancePrice(performancePriceId);
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String updatePerformancePrice(@PathVariable("id") Long performancePriceId,
            @RequestParam long newPerformance, @RequestParam long newSection, @RequestParam float ticketPrice) {

        return ppeservice.updatePerformancePrice(performancePriceId, newPerformance, newSection, ticketPrice);

    }

}
