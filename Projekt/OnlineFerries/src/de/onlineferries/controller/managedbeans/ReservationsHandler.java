package de.onlineferries.controller.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import de.onlineferries.model.service.ReservationService;
import de.onlineferries.view.ReservationView;
import de.onlineferries.view.TravellerView;

@ManagedBean
@SessionScoped
public class ReservationsHandler implements Serializable {

	private static final long serialVersionUID = 1L;
	private String selectedReservation;
	private String[] reservationValues;
	private ReservationView reservation;
	private int travellers;

	private List<ReservationView> reservations = new ArrayList<ReservationView>();

	@ManagedProperty("#{serviceLocatorBean}")
	private ServiceLocator serviceLocator;

	public void setServiceLocator(ServiceLocator serviceLocatorBean) {
		this.serviceLocator = serviceLocatorBean;
	}

	@ManagedProperty("#{routeHandler}")
	private RouteHandler routeHandler;

	public void setRouteHandler(RouteHandler routeHandler) {
		this.routeHandler = routeHandler;
	}

	@ManagedProperty("#{tripHandler}")
	private TripHandler tripHandler;

	public void setTripHandler(TripHandler tripHandler) {
		this.tripHandler = tripHandler;
	}

	@ManagedProperty("#{loginHandler}")
	private LoginHandler loginHandler;

	public void setLoginHandler(LoginHandler loginHandler) {
		this.loginHandler = loginHandler;
	}

	public String reservations() {

		ReservationService rs = serviceLocator.getReservationService();

		reservations = rs.getReservationsForCustomer(loginHandler.getCustomer());
		if (!reservations.isEmpty()) {

			reservationValues = new String[reservations.size()];
			List<String> help = new ArrayList<String>();
			for (ReservationView r : reservations) {
				help.add(r.getReservation_id().toString());
			}

			reservationValues = help.toArray(reservationValues);

			return "success";
		}

		return "noRes";
	}

	public String changeReservation() {

		reservation = reservations.get(Integer.parseInt(selectedReservation) - 1);

		if (reservation != null) {
			travellers = reservation.getTravellerNames().size();

			return "success";
		}

		return "NoSuccess";
	}

	public void changeTraveller(ValueChangeEvent ev) {
		travellers = (Integer) ev.getNewValue();
		ArrayList<TravellerView> help = new ArrayList<TravellerView>(travellers);
		for (int i = 0; i < travellers; i++)
			help.add(new TravellerView(i, ""));
		reservation.setTravellerNames(help);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void changeReservation(ValueChangeEvent ev) {
		selectedReservation = (String) ev.getNewValue();

		FacesContext.getCurrentInstance().renderResponse();
	}

	public int[] getTravellerValues() {
		return new int[] { 0, 1, 2, 3, 4, 5, 6 };
	}

	public List<ReservationView> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationView> reservations) {
		this.reservations = reservations;
	}

	public String getSelectedReservation() {
		return selectedReservation;
	}

	public void setSelectedReservation(String selectedReservation) {
		this.selectedReservation = selectedReservation;
	}

	public String[] getReservationValues() {
		return reservationValues;
	}

	public void setReservationValues(String[] reservationValues) {
		this.reservationValues = reservationValues;
	}

	public ReservationView getReservation() {
		return reservation;
	}

	public void setReservation(ReservationView reservation) {
		this.reservation = reservation;
	}

	public int getTravellers() {
		return travellers;
	}

	public void setTravellers(int travellers) {
		this.travellers = travellers;
	}
}
