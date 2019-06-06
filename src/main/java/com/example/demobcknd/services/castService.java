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

    public void addCast(cast newCast) {
        
        castRep.save(newCast);
    }

    public void deleteCast(long castId) {
        castRep.deleteById(castId);
    }

    public void updateCast(long id, cast newCast) {
 
        newCast.setCastId(id);
        castRep.save(newCast);
    }

}