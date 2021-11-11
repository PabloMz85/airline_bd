package com.bd.airline.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Passenger extends Traveler {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_passenger")
    private Long id;

    private String phone;

    private String address;

    @ManyToMany(
    		mappedBy = "passengers"
    	)
    private List<Reservation> passengers;
    
    public Passenger() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Reservation> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Reservation> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", phone=" + phone + ", address=" + address + ", passengers=" + passengers + "]";
	}
}
