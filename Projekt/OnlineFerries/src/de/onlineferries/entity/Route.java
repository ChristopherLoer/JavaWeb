package de.onlineferries.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

@Entity
public class Route implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
//	private Integer ship_id;
	private String start;
	private String destination;
	private List<Trip> trips;
	private Ship ship;
	
	public Route() {}

	@Id
	@Column(name="route_id")
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

//	public Integer getShip_id() {
//		return ship_id;
//	}
//
//	public void setShip_id(Integer ship_id) {
//		this.ship_id = ship_id;
//	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@OneToMany(mappedBy="route")
	@OrderColumn(name="trip_index")
	public List<Trip> getTrips() { return trips; }
	public void setTrips(List<Trip> trips) { this.trips = trips; }

	
	@OneToOne
	@JoinColumn(name="ship_id")
	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

}
