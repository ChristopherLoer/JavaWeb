package de.onlineferries.controller.managedbeans;

import de.onlineferries.model.service.LoginService;
import de.onlineferries.model.service.NewCustomerService;
import de.onlineferries.model.service.ReservationService;
import de.onlineferries.model.service.RouteService;
import de.onlineferries.model.service.ShipService;

public interface ServiceLocator {

	public LoginService getLoginService();
	public RouteService getRouteService();
	public ShipService getShipService();
	public ReservationService getReservationService();
	public NewCustomerService getNewCustomerService();

}
