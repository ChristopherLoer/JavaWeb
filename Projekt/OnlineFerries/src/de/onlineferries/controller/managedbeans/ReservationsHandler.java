package de.onlineferries.controller.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import de.onlineferries.view.ReservationsView;

@ManagedBean
@SessionScoped
public class ReservationsHandler implements Serializable {

	private static final long serialVersionUID = 1L;

	private ReservationsView reservations;

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

	public ReservationsView getReservations() {
		return reservations;
	}

	public void setReservations(ReservationsView reservations) {
		this.reservations = reservations;
	}
}
