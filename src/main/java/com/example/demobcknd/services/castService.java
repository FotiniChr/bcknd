package com.example.demobcknd.services;

import com.example.demobcknd.models.cast;
import com.example.demobcknd.repositories.castRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class castService {
    @Autowired
    private castRepository castRep;

    public Iterable<cast> findAllCast() {
        return castRep.findAll();

    }

    public cast findCast(long castId) {
        return castRep.findById(castId).get();
    }

    public String addCast(String direction, String stage_composition, String costumes, String stars, String actors) {
        cast c = new cast();
        c.setDirection(direction);
        c.setStage_composition(stage_composition);
        c.setCostumes(costumes);
        c.setStars(stars);
        c.setActors(actors);
        castRep.save(c);
        return "Saved";
    }

    public String deleteCast(long castId) {
        castRep.deleteById(castId);
        return "deleted";
    }

    public String updateCast(long castId, String direction, String stage_composition, String costumes,
            String stars, String actors) {

        cast c = castRep.findById(castId).get();

        c.setDirection(direction);
        c.setStage_composition(stage_composition);
        c.setCostumes(costumes);
        c.setStars(stars);
        c.setActors(actors);
        castRep.save(c);
        return "Saved";
    }

}