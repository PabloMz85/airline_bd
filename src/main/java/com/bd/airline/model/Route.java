package com.bd.airline.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Route {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_route")
    private Long id;

    private String startAirport;

    private String startCity;

    private String destinyAirport;

    private String destinyCity;

    private String airline;

    private float actualPrice;

    @OneToMany(
            mappedBy = "route",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
        )
    private List<Flight> flights;

    @OneToMany(
            mappedBy = "route",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
        )
    private List<HistoricalPrice> historicalPrices;

    public Route () {

    }

    /*
    * CONSTRUCTOR
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getDestinyAirport() {
        return destinyAirport;
    }

    public void setDestinyAirport(String destinyAirport) {
        this.destinyAirport = destinyAirport;
    }

    public String getDestinyCity() {
        return destinyCity;
    }

    public void setDestinyCity(String destinyCity) {
        this.destinyCity = destinyCity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public float getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<HistoricalPrice> getHistoricalPrices() {
        return historicalPrices;
    }

    public void setHistoricalPrices(List<HistoricalPrice> historicalPrices) {
        this.historicalPrices = historicalPrices;
    }
}
