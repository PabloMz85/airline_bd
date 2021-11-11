package com.bd.airline.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoricalPrice {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_historical_price")
    private Long id;

    private float price;

    private Date startDate;

    private Date finishDate;
    
    @ManyToOne(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL
		)
    private Route route;
    
    public HistoricalPrice() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "HistoricalPrice [id=" + id + ", price=" + price + ", startDate=" + startDate + ", finishDate="
				+ finishDate + ", route=" + route + "]";
	}
	
}
