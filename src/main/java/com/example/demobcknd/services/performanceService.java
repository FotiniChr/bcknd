package com.example.demobcknd.services;

import com.example.demobcknd.models.cast;
import com.example.demobcknd.models.performance;
import com.example.demobcknd.repositories.castRepository;
import com.example.demobcknd.repositories.performanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class performanceService {
    @Autowired
    private performanceRepository performanseRep;

    @Autowired // epeidh exo pedio castId (fk)
    private castRepository castRep;

    public Iterable<performance> findAllPerformances() {
        return performanseRep.findAll();
    }

    public performance findPerformance(Long performanceId) {
        return performanseRep.findById(performanceId).get();
    }

    public String addPerformance(performance newPerformance) {

        performanseRep.save(newPerformance);
        return "saved";
    }

    public String deletePerformance(Long performanceId) {

        performanseRep.deleteById(performanceId);
        return "deleted";
    }

    public String updatePerformance(Long id, performance newPerformance) {

        cast newcast = castRep.findById(newPerformance.getNewCast().getCastId()).get();

        performance p = performanseRep.findById(id).get();
        p.setName(newPerformance.getName());
        p.setNewCast(newcast);
        p.setDate(newPerformance.getDate());
        p.setStart_time(newPerformance.getStart_time());
        p.setDuration(newPerformance.getDuration());

        performanseRep.save(p);
        return "updated";
    }

}