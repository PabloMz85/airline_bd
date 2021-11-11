package com.bd.airline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_flight")
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private Long number;

    @Column(nullable = false)
    private Date dateOfFlight;

    @Column(nullable = false)
    private float weightLimit;

    @Column(nullable = false)
    private int reservedSeats;

    @ManyToOne(
    		fetch = FetchType.EAGER, 
    		cascade = {}
    	)
    @JoinColumn(
    		name = "id_airplane", 
    		nullable = false
    	)
    private Airplane airplane;

    @OneToMany(
            mappedBy = "flight",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
        )
    private List<Reservation> reservations;

    @ManyToOne(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL
		)
    @JoinColumn(name = "id_route")
    private Route route;

    @ManyToOne(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL
		)
    @JoinColumn(name = "id_pilot")
    private Pilot pilot;

    @Version
    @Column(name = "version")
    private int version;

    
    public Flight() {}

    public Flight(long number, Date dateOfFlight, float weightLimit, Airplane airplane, Route route, Pilot pilot){
        this.number = number;
        this.dateOfFlight = dateOfFlight;
        this.weightLimit = weightLimit;
        this.airplane = airplane;
        this.route = route;
        this.pilot = pilot;
        this.reservations = new ArrayList<Reservation>();
        this.reservedSeats = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public float getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(float weightLimit) {
        this.weightLimit = weightLimit;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

	@Override
	public String toString() {
		return "Flight [id=" + id + ", number=" + number + ", dateOfFlight=" + dateOfFlight + ", weightLimit="
				+ weightLimit + ", reservedSeats=" + reservedSeats + ", airplane=" + airplane + ", reservations="
				+ reservations + ", route=" + route + ", pilot=" + pilot + ", version=" + version + "]";
	}
    
}
