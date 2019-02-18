package de.onlineferries.view;

import java.io.Serializable;
import java.util.List;

public class ReservationsView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ReservationView> reservations;

	public ReservationsView(List<ReservationView> reservations) {
		super();
		this.reservations = reservations;
	}

	public List<ReservationView> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationView> reservations) {
		this.reservations = reservations;
	}

}