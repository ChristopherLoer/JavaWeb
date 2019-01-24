package de.onlineferries.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(CabinReservationId.class)
@Table(name="reservation_cabin")
public class CabinReservation implements Serializable  {

	private static final long serialVersionUID = 1L;

	private Cabin cabin;
	private Reservation reservation;
	private int count;
	
	@Id
	@ManyToOne(optional=false)
	@JoinColumn(name="cabintype_id")
	public Cabin getCabin() {
		return cabin;
	}
	public void setCabin(Cabin cabin) {
		this.cabin = cabin;
	}
	
	@Id
	@ManyToOne(optional=false)
	@JoinColumn(name="reservation_id")
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


}
