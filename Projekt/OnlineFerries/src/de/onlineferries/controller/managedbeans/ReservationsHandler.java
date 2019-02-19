package de.onlineferries.controller.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import de.onlineferries.model.service.ReservationService;
import de.onlineferries.view.ReservationView;

@ManagedBean
@SessionScoped
public class ReservationsHandler implements Serializable {

	private static final long serialVersionUID = 1L;
	private int selectedReservation;

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
		System.out.println("Reservations Entered");

		ReservationService rs = serviceLocator.getReservationService();

		System.out.println("Service found");
		reservations = rs.getReservationsForCustomer(loginHandler.getCustomer());
		if (!reservations.isEmpty()) {
			System.out.println("Reservations Found");
			return "success";
		}
		System.out.println("No Reservations Found");

		return "noRes";
	}

	public String changeReservation() {
		return "success";
	}

	public List<ReservationView> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationView> reservations) {
		this.reservations = reservations;
	}

	public int getSelectedReservation() {
		return selectedReservation;
	}

	public void setSelectedReservation(int selectedReservation) {
		this.selectedReservation = selectedReservation;
	}
}
