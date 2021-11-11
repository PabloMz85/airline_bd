package com.bd.airline.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reservation")
    private Long id;

    private int numberOfReservation;

    private Date dateOfReservation;

    @ElementCollection
    private List<Integer> numbersOfSeats;

    private boolean paid;

    @ManyToOne(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL
		)
    private User user;

    @ManyToMany
    @JoinTable(
			name = "reservation_passenger", 
			joinColumns = @JoinColumn(name = "passenger_id"), 
			inverseJoinColumns = @JoinColumn(name = "reservation_id")
		)
    private List<Passenger> passengers;
    
    @ManyToOne(
    		fetch = FetchType.LAZY, 
    		cascade = CascadeType.ALL
    	)
    private Flight flight;

        
    public Reservation() {}
    

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfReservation() {
        return numberOfReservation;
    }

    public void setNumberOfReservation(int numberOfReservation) {
        this.numberOfReservation = numberOfReservation;
    }

    public Date getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(Date dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public List<Integer> getNumbersOfSeats() {
        return numbersOfSeats;
    }

    public void setNumbersOfSeats(List<Integer> numbersOfSeats) {
        this.numbersOfSeats = numbersOfSeats;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
