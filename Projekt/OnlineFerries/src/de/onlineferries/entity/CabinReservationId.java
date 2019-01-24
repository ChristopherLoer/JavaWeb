package de.onlineferries.entity;

import java.io.Serializable;

public class CabinReservationId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer reservation_id;
	private Integer cabin_id;
	
	public Integer getReservation() {
		return reservation_id;
	}
	public void setReservation(Integer reservation_id) {
		this.reservation_id = reservation_id;
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
		result = prime * result
				+ ((reservation_id == null) ? 0 : reservation_id.hashCode());
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
		CabinReservationId other = (CabinReservationId) obj;
		if (cabin_id == null) {
			if (other.cabin_id != null)
				return false;
		} else if (!cabin_id.equals(other.cabin_id))
			return false;
		if (reservation_id == null) {
			if (other.reservation_id != null)
				return false;
		} else if (!reservation_id.equals(other.reservation_id))
			return false;
		return true;
	}
	
}
