package de.onlineferries.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ShipCabinId.class)
@Table(name="ship_cabin")
public class ShipCabin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Ship ship;
	private Cabin cabin;
	private int count;
	private double price;
	
	@Id
	@ManyToOne(optional=false)
	@JoinColumn(name="ship_id")
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	@Id
	@ManyToOne(optional=false)
	@JoinColumn(name="cabintype_id")
	public Cabin getCabin() {
		return cabin;
	}
	public void setCabin(Cabin cabin) {
		this.cabin = cabin;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
