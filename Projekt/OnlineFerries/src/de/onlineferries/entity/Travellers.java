package de.onlineferries.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Travellers implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	
	String fullName;
	Reservation reservation;

	public Travellers() {}
	
	public Travellers(String fullName) {
		this.fullName = fullName;
	}
	
	@Id
	@GeneratedValue
	@Column(name="travellers_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@ManyToOne
	@JoinColumn(name="reservation_id")
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
}
