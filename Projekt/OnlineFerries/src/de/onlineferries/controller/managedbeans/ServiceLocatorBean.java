package de.onlineferries.controller.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import de.onlineferries.model.service.LoginService;
import de.onlineferries.model.service.LoginServiceImpl;
import de.onlineferries.model.service.NewCustomerService;
import de.onlineferries.model.service.NewCustomerServiceImpl;
import de.onlineferries.model.service.ReservationService;
import de.onlineferries.model.service.ReservationServiceImpl;
import de.onlineferries.model.service.RouteService;
import de.onlineferries.model.service.RouteServiceImpl;
import de.onlineferries.model.service.ShipService;
import de.onlineferries.model.service.ShipServiceImpl;

@ManagedBean
@ApplicationScoped
public class ServiceLocatorBean implements ServiceLocator, Serializable {

	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	private RouteService routeService;
	private ShipService shipService;
	private ReservationService reservationService;
	private NewCustomerService newCustomerService;
	
	public ServiceLocatorBean() {
		loginService = new LoginServiceImpl();
		routeService = new RouteServiceImpl();
		shipService = new ShipServiceImpl();
		reservationService = new ReservationServiceImpl();
		newCustomerService = new NewCustomerServiceImpl();
	}
	
	@Override
	public LoginService getLoginService() {
		return loginService;
	}
	
	@Override
	public RouteService getRouteService() {
		return routeService;
	}

	@Override
	public ShipService getShipService() {
		return shipService;
	}

	@Override
	public ReservationService getReservationService() {
		return reservationService;
	}

	@Override
	public NewCustomerService getNewCustomerService() {
		return newCustomerService;
	}
	
	

}
