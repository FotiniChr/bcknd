package com.example.demobcknd.services;

import com.example.demobcknd.models.section;
import com.example.demobcknd.models.performance;
import com.example.demobcknd.models.performancePrice;
import com.example.demobcknd.repositories.sectionRepository;
import com.example.demobcknd.repositories.performanceRepository;
import com.example.demobcknd.repositories.performancePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class performancePriceService {

    @Autowired
    private performancePriceRepository p;

    @Autowired // epeidh exo pedio section_id (fk)
    private sectionRepository sectRep;

    @Autowired // epeidh exo pedio performance_id (fk)
    private performanceRepository perfrep;

    public Iterable<performancePrice> findAllPerformancePrices() {
        return p.findAll();
    }

    public performancePrice findPerformancePrice(Long performancePriceId) {
        return p.findById(performancePriceId).get();
    }

    public String addPerformancePrice(long newPerformance, long newSection, float ticketPrice) {

        performance newperf = perfrep.findById(newPerformance).get();
        section newsec = sectRep.findById(newSection).get();

        performancePrice newperprice = new performancePrice();
        newperprice.setNewPerformance(newperf);
        newperprice.setNewSection(newsec);
        newperprice.setTicketPrice(ticketPrice);

        p.save(newperprice);
        return "saved";
    }

    public String deletePerformancePrice(Long performancePriceId) {

        p.deleteById(performancePriceId);
        return "deleted";
    }

    public String updatePerformancePrice(long performancePriceId, long newPerformance, long newSection,
            float ticketPrice) {

        performance newperf = perfrep.findById(newPerformance).get();
        section newsec = sectRep.findById(newSection).get();

        performancePrice newperprice = p.findById(performancePriceId).get();
        newperprice.setNewPerformance(newperf);
        newperprice.setNewSection(newsec);
        newperprice.setTicketPrice(ticketPrice);

        p.save(newperprice);
        return "updated";
    }

}