package de.onlineferries.controller.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import de.onlineferries.model.service.RouteService;
import de.onlineferries.view.TripView;

@ManagedBean
@SessionScoped
public class TripHandler implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{serviceLocatorBean}")
	private ServiceLocator serviceLocator;
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
	
	@ManagedProperty("#{routeHandler}")
	private RouteHandler routeHandler;
	public void setRouteHandler(RouteHandler routeHandler) { this.routeHandler = routeHandler; }

	private List<TripView> trips;
	public List<TripView> getTrips() { return trips; }
	
	private TripView trip;
	public TripView getTrip() { return trip; }
	public void setTrip(TripView trip) { this.trip = trip; }
	
	public String trips() {
		
		RouteService routeService = serviceLocator.getRouteService();
		trips = routeService.findTrips(routeHandler.getRoute().getRoute_id());
		if (trips.size() > 0) 
			trip = trips.get(0);
		
		return "success";
	}
	
	public String back() {
		return "/auswahlRoute.xhtml?faces-redirect=true";
	}
	
	public Converter getTripConverter() {
		return new Converter() {

			@Override
			public Object getAsObject(FacesContext context, UIComponent component,
					String value) {
				for (int i = 0; i < trips.size(); i++) {
					TripView t = trips.get(i);
					if ((new Integer(t.getTrip_id()).toString()).equals(value))
						return t;
				}				
				return null;
			}

			@Override
			public String getAsString(FacesContext context, UIComponent component,
					Object value) {
				return (new Integer(((TripView)value).getTrip_id())).toString();
			}			
		};
	}
}
