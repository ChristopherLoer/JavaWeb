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

	private List<ReservationView> reservations = new ArrayList<ReservationView>();
	private ReservationView resView;

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

	public List<ReservationView> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationView> reservations) {
		this.reservations = reservations;
	}
	
	public ReservationView getResView() {
		return resView;
	}

	public void setResView(ReservationView resView) {
		this.resView = resView;
	}

	public String changeReservation(int res_id) {
		System.out.println("change reservation with id: " + res_id);
		for(ReservationView res: reservations) {
			if (res.getReservation_id().equals(res_id)) {
				resView = new ReservationView(res.getTrip(), res.getCustomer(), res.getShipCabins(), res.getCars(), res.getTravellerNames());
				return "success";
			}
		}		
		return "failed";
	}
}
