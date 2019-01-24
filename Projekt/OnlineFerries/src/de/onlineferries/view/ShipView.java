package de.onlineferries.view;

import java.io.Serializable;

public class ShipView implements Serializable {

	private static final long serialVersionUID = 1L;

	int ship_id;
	String description;
	int cars;
	int passengers;

	public ShipView() {}

	public ShipView(int ship_id, String description, int cars, int passengers) {
		super();
		this.ship_id = ship_id;
		this.description = description;
		this.cars = cars;
		this.passengers = passengers;
	}

	public int getShip_id() {
		return ship_id;
	}

	public void setShip_id(int ship_id) {
		this.ship_id = ship_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCars() {
		return cars;
	}

	public void setCars(int cars) {
		this.cars = cars;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	
}
