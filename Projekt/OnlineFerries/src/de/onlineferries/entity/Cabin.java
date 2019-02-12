package de.onlineferries.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cabintype")
public class Cabin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String description;
	private int passengers;
	
	public Cabin() {}
	
	@Id
	@Column(name="cabintype_id")
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

	@Override
	public String toString() {
		return "Cabin [id=" + id + ", description=" + description + ", passengers=" + passengers + "]";
	}

}
