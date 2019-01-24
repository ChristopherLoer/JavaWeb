package de.onlineferries.view;

import java.io.Serializable;

public class RouteView implements Serializable {

	private static final long serialVersionUID = 1L;

	private int route_id;
	private String start;
	private String destination;
	private int ship_id;

	public RouteView() {}
	
	public RouteView(int route_id, String start, String destination) {
		super();
		this.route_id = route_id;
		this.start = start;
		this.destination = destination;
	}
	
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getShip_id() {
		return ship_id;
	}
	public void setShip_id(int ship_id) {
		this.ship_id = ship_id;
	}
}
