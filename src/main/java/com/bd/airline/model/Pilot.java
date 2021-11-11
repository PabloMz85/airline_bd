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
public class Pilot extends Traveler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pilot")
    private Long id;

    private String category;

    private int numberOfFlights;

    private int yearsInService;

    @OneToMany(
            mappedBy = "pilot",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
        )
    private List<Flight> flight;

    
    public Pilot() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNumberOfFlights() {
		return numberOfFlights;
	}

	public void setNumberOfFlights(int numberOfFlights) {
		this.numberOfFlights = numberOfFlights;
	}

	public int getYearsInService() {
		return yearsInService;
	}

	public void setYearsInService(int yearsInService) {
		this.yearsInService = yearsInService;
	}

	public List<Flight> getFlight() {
		return flight;
	}

	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", category=" + category + ", numberOfFlights=" + numberOfFlights
				+ ", yearsInService=" + yearsInService + ", flight=" + flight + "]";
	}
}
