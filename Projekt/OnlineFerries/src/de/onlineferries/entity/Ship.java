package de.onlineferries.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Ship implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String description;
	private int passengers;
	private int cars;
	
	private List<ShipCabin> shipCabin;
	
	public Ship() {}
	
	@Id
	@Column(name="ship_id")
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public int getCars() {
		return cars;
	}

	public void setCars(int cars) {
		this.cars = cars;
	}	
	
	@OneToMany(mappedBy="ship")
	@OrderColumn(name="cabin_index")
	public List<ShipCabin> getShipCabin() { return shipCabin; }
	public void setShipCabin(List<ShipCabin> shipCabin) { this.shipCabin = shipCabin; }
	
}
