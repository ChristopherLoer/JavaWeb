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
	private int travellers;

	private List<ReservationView> reservations = new ArrayList<ReservationView>();
	private ReservationView resView;
	private int countTravellers;

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

			return "success";
		}

		return "noRes";
	}

	public void changeTraveller(ValueChangeEvent ev) {
		travellers = (Integer) ev.getNewValue();
		ArrayList<TravellerView> help = new ArrayList<TravellerView>(travellers);
		for (int i = 0; i < travellers; i++)
			help.add(new TravellerView(i, ""));
//		reservation.setTravellerNames(help);
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

	public ReservationView getResView() {
		return resView;
	}

	public void setResView(ReservationView resView) {
		this.resView = resView;
	}

	public void setCountTravellers(int countTravellers) {
		this.countTravellers = countTravellers;
	}

	public int getCountTravellers() {
		setCountTravellers(resView.getTravellerNames().size());
		return resView.getTravellerNames().size();
	}

	public String changeReservation(int res_id) {
		System.out.println("change reservation with id: " + res_id);
		for (ReservationView res : reservations) {
			if (res.getReservation_id().equals(res_id)) {
				resView = new ReservationView(res.getTrip(), res.getCustomer(), res.getShipCabins(), res.getCars(),
						res.getTravellerNames());
				return "success";
			}
		}
		return "failed";
	}

	public String update() {

		ReservationService reservationService = serviceLocator.getReservationService();
		reservationService.updateReservation(resView);

		return "success";
	}
}
