package de.onlineferries.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Route route;
	private Date date;
	private Date departure;
	private Date arrival;
	private double price_car;
	private double price_passenger;
	
	@Id
	@Column(name="trip_id")
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public Trip() {}
	
	@ManyToOne
	@JoinColumn(name="route_id")
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	
	public double getPrice_car() {
		return price_car;
	}
	public void setPrice_car(double price_car) {
		this.price_car = price_car;
	}
	
	public double getPrice_passenger() {
		return price_passenger;
	}
	public void setPrice_passenger(double price_passenger) {
		this.price_passenger = price_passenger;
	}
	
}
