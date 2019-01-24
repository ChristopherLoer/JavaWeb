package de.onlineferries.view;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TripView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int tripid;
	private Date date;
	private Date departure;
	private Date arrival;
	private int routeid;
	private double carPrice;
	private double passengerPrice;

	public TripView() {}

	public TripView(int tripid, Date date, Date departure, Date arrival,
			int routeid, double carPrice, double passengerPrice) {
		super();
		this.tripid = tripid;
		this.date = date;
		this.departure = departure;
		this.arrival = arrival;
		this.routeid = routeid;
		this.carPrice = carPrice;
		this.passengerPrice = passengerPrice;
	}

	public int getTrip_id() {
		return tripid;
	}
	public void setTrip_id(int tripid) {
		this.tripid = tripid;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}

	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	public double getPassengerPrice() {
		return passengerPrice;
	}
	public void setPassengerPrice(double passengerPrice) {
		this.passengerPrice = passengerPrice;
	}
	
	public String getTripLabel() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("EEE, d MMM yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");

		String result = sdfDate.format(date);
		result += ": " + sdfTime.format(departure);
		result += " - " + sdfTime.format(arrival);			
		return result;
	}
	
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(date);
	}

	public String getFormatDeparture() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(departure);		
	}

	public String getFormatArrival() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(arrival);		
	}
	
}
