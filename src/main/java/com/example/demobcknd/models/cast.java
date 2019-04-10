package com.example.demobcknd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // This tells Hibernate to make a table out of this class
public class cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CastId;

    private String direction; // σκηνοθεσια
    private String stage_composition; // σκηνική σύνθεση
    private String costumes;
    private String stars;
    private String actors;

    // ++ gia to performance.java
    @OneToOne(mappedBy = "newCast")
    @JsonIgnore
    private performance per;



    public cast() {
    }

    public cast(String direction, String stage_composition, String costumes, String stars, String actors) {
        this.direction = direction;
        this.stage_composition = stage_composition;
        this.costumes = costumes;
        this.stars = stars;
        this.actors = actors;
    }

    public long getCastId() {
        return this.CastId;
    }

    public void setCastId(long CastId) {
        this.CastId = CastId;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getStage_composition() {
        return this.stage_composition;
    }

    public void setStage_composition(String stage_composition) {
        this.stage_composition = stage_composition;
    }

    public String getCostumes() {
        return this.costumes;
    }

    public void setCostumes(String costumes) {
        this.costumes = costumes;
    }

    public String getStars() {
        return this.stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getActors() {
        return this.actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public cast id(long CastId) {
        this.CastId = CastId;
        return this;
    }

    public cast direction(String direction) {
        this.direction = direction;
        return this;
    }

    public cast stage_composition(String stage_composition) {
        this.stage_composition = stage_composition;
        return this;
    }

    public cast costumes(String costumes) {
        this.costumes = costumes;
        return this;
    }

    public cast stars(String stars) {
        this.stars = stars;
        return this;
    }

    public cast actors(String actors) {
        this.actors = actors;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getCastId() + "'" + ", direction='" + getDirection() + "'" + ", tage_composition='"
                + getStage_composition() + "'" + ", costumes='" + getCostumes() + "'" + ", stars='" + getStars() + "'"
                + ", actors='" + getActors() + "'" + "}";
    }

}
