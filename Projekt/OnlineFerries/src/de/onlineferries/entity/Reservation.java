package de.onlineferries.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Reservation implements Serializable  {

	private static final long serialVersionUID = 1L;

	Integer id;
	
	Trip trip;
	Customer customer;
	int cars;

	private List<CabinReservation> cabins;
	private List<Travellers> travellers;
	
	@Id
	@Column(name="reservation_id")
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="trip_id")
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getCars() {
		return cars;
	}
	public void setCars(int cars) {
		this.cars = cars;
	}
	
	@OneToMany(mappedBy="reservation", cascade=CascadeType.ALL)
	@OrderColumn(name="cabin_index")
	public List<CabinReservation> getCabins() {
		return cabins;
	}
	public void setCabins(List<CabinReservation> cabins) {
		this.cabins = cabins;
	}
	
	@OneToMany(mappedBy="reservation", cascade=CascadeType.ALL)
	@OrderColumn(name="travellers_index")
	public List<Travellers> getTravellers() {
		return travellers;
	}
	public void setTravellers(List<Travellers> travellers) {
		this.travellers = travellers;
	}

}
