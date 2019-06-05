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
    private performancePriceRepository perfPriceRepository;

    @Autowired // epeidh exo pedio section_id (fk)
    private sectionRepository sectRep;

    @Autowired // epeidh exo pedio performance_id (fk)
    private performanceRepository perfrep;

    public Iterable<performancePrice> findAllPerformancePrices() {
        return perfPriceRepository.findAll();
    }

    public performancePrice findPerformancePrice(Long performancePriceId) {
        return perfPriceRepository.findById(performancePriceId).get();
    }

    public void addPerformancePrice(performancePrice newPerformancePrice) {

        perfPriceRepository.save(newPerformancePrice);
    }

    public String deletePerformancePrice(Long performancePriceId) {

        perfPriceRepository.deleteById(performancePriceId);
        return "deleted";
    }



    public String updatePerformancePrice(long id, performancePrice newPerformancePrice) {

        performance newperf = perfrep.findById(newPerformancePrice.getNewPerformance().getPerformanceId()).get();
        section newsec = sectRep.findById(newPerformancePrice.getNewSection().getSectionId()).get();

        performancePrice newperprice = perfPriceRepository.findById(id).get();
        newperprice.setNewPerformance(newperf);
        newperprice.setNewSection(newsec);
        newperprice.setTicketPrice(newPerformancePrice.getTicketPrice());

        perfPriceRepository.save(newperprice);
        return "updated";
    }

}