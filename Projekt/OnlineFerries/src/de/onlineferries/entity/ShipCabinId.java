package de.onlineferries.entity;

import java.io.Serializable;

public class ShipCabinId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer ship_id;
	private Integer cabin_id;
	
	public Integer getShip() {
		return ship_id;
	}
	public void setShip(Integer ship_id) {
		this.ship_id = ship_id;
	}
	public Integer getCabin() {
		return cabin_id;
	}
	public void setCabin(Integer cabin_id) {
		this.cabin_id = cabin_id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cabin_id == null) ? 0 : cabin_id.hashCode());
		result = prime * result + ((ship_id == null) ? 0 : ship_id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipCabinId other = (ShipCabinId) obj;
		if (cabin_id == null) {
			if (other.cabin_id != null)
				return false;
		} else if (!cabin_id.equals(other.cabin_id))
			return false;
		if (ship_id == null) {
			if (other.ship_id != null)
				return false;
		} else if (!ship_id.equals(other.ship_id))
			return false;
		return true;
	}
		
}
