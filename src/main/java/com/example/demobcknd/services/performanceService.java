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

    public String addPerformance(String name, long newCast, String date, String start_time, int duration) {

        cast newcast = castRep.findById(newCast).get();

        performance newper = new performance();
        newper.setName(name);
        newper.setNewCast(newcast);
        newper.setDate(date);
        newper.setStart_time(start_time);
        newper.setDuration(duration);

        performanseRep.save(newper);
        return "saved";
    }

    public String deletePerformance(Long performanceId) {

        performanseRep.deleteById(performanceId);
        return "deleted";
    }

    public String updatePerformance(Long performanceId, String name, long newCast, String date, String start_time,
            int duration) {

        cast newcast = castRep.findById(newCast).get();

        performance newper = performanseRep.findById(performanceId).get();
        newper.setName(name);
        newper.setNewCast(newcast);
        newper.setDate(date);
        newper.setStart_time(start_time);
        newper.setDuration(duration);

        performanseRep.save(newper);
        return "updated";
    }

}