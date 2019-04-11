package com.example.demobcknd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class performancePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performancePriceId;

    // pedio performance_id -FK-
    @ManyToOne
    @JoinColumn(name = "performance_id", referencedColumnName = "performanceId")
    private performance newPerformance;

    // pedio section_id -FK-
    @OneToOne
    @JoinColumn(name = "section_id", referencedColumnName = "sectionId")
    private section newSection;

    private float ticketPrice;

    public performancePrice() {
    }

    public performancePrice(performance newPerformance, section newSection, float ticketPrice) {
        this.newPerformance = newPerformance;
        this.newSection = newSection;
        this.ticketPrice = ticketPrice;
    }

    public Long getPerformancePriceId() {
        return this.performancePriceId;
    }

    public void setPerformancePriceId(Long performancePriceId) {
        this.performancePriceId = performancePriceId;
    }

    public performance getNewPerformance() {
        return this.newPerformance;
    }

    public void setNewPerformance(performance newPerformance) {
        this.newPerformance = newPerformance;
    }

    public section getNewSection() {
        return this.newSection;
    }

    public void setNewSection(section newSection) {
        this.newSection = newSection;
    }

    public float getTicketPrice() {
        return this.ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public performancePrice performancePriceId(Long performancePriceId) {
        this.performancePriceId = performancePriceId;
        return this;
    }

    public performancePrice newPerformance(performance newPerformance) {
        this.newPerformance = newPerformance;
        return this;
    }

    public performancePrice newSection(section newSection) {
        this.newSection = newSection;
        return this;
    }

    public performancePrice ticketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " performancePriceId='" + getPerformancePriceId() + "'" + ", newPerformance='"
                + getNewPerformance() + "'" + ", newSection='" + getNewSection() + "'" + ", ticketPrice='"
                + getTicketPrice() + "'" + "}";
    }

}