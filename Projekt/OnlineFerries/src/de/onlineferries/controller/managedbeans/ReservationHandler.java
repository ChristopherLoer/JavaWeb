package de.onlineferries.controller.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import de.onlineferries.model.service.ReservationService;
import de.onlineferries.model.service.ShipService;
import de.onlineferries.view.ReservationView;
import de.onlineferries.view.ShipCabinView;
import de.onlineferries.view.TravellerView;

@ManagedBean
@SessionScoped
public class ReservationHandler implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ShipCabinView> shipCabins;
	private int cars;
	private int travellers;
	private List<TravellerView> travellerNames;

	private double reservationPrice;

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

	public int[] getTravellerValues() {
		return new int[] { 0, 1, 2, 3, 4, 5, 6 };
	}

	public List<ShipCabinView> getShipCabins() {
		return shipCabins;
	}

	public void setShipCabins(List<ShipCabinView> shipCabins) {
		this.shipCabins = shipCabins;
	}

	public int getCars() {
		return cars;
	}

	public void setCars(int cars) {
		this.cars = cars;
	}

	public int getTravellers() {
		return travellers;
	}

	public void setTravellers(int travellers) {
		this.travellers = travellers;
	}

	public List<TravellerView> getTravellerNames() {
		return travellerNames;
	}

	public void setTravellerNames(List<TravellerView> travellerNames) {
		this.travellerNames = travellerNames;
	}

	public String enterReservation() {

		ShipService shipService = serviceLocator.getShipService();
		shipCabins = shipService.findAllShipCabins(routeHandler.getShip().getShip_id());

		return "success";

	}

	public String selectCustomerType() {
		if (serviceLocator.getReservationService().isAvailable(tripHandler.getTrip().getTrip_id(), shipCabins, cars,
				travellers)) {
			ReservationService reservationService = serviceLocator.getReservationService();
			reservationPrice = reservationService.getReservationPrice(tripHandler.getTrip().getTrip_id(), shipCabins,
					getCars(), getTravellers());

			return "successSelect";
		}
		return "notAvailable";

	}
	
	public String registration() {
		return "";
	}

	public String saveReservation() {

		ReservationView reservationView = new ReservationView(tripHandler.getTrip(), loginHandler.getCustomer(),
				shipCabins, cars, travellerNames);

		ReservationService reservationService = serviceLocator.getReservationService();
		reservationService.insertReservation(reservationView);

		return "successSave";
	}

	public String back() {
		return "back";
	}

	public void changeTraveller(ValueChangeEvent ev) {
		travellers = (Integer) ev.getNewValue();
		travellerNames = new ArrayList<TravellerView>(travellers);
		for (int i = 0; i < travellers; i++)
			travellerNames.add(new TravellerView(i, ""));
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void validateTravellerName(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

	}

	public double getReservationPrice() {
		return reservationPrice;
	}

	public void setReservationPrice(double reservationPrice) {
		this.reservationPrice = reservationPrice;
	}

	public List<ShipCabinView> getSelectedShipCabins() {

		List<ShipCabinView> selectedShipCabins = new ArrayList<ShipCabinView>();

		for (ShipCabinView sc : shipCabins) {
			if (sc.getRes_count() > 0)
				selectedShipCabins.add(sc);
		}

		return selectedShipCabins;
	}

	public String registration() {
		// TODO implement code?
		return "back";
	}
}
