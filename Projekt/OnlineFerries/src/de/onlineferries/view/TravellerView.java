package de.onlineferries.view;

import java.io.Serializable;

public class TravellerView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int id;
	
	public TravellerView(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public int getId() { return id; }
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
