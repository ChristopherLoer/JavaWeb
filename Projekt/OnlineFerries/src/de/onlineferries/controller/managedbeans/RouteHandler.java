package de.onlineferries.controller.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;

import de.onlineferries.model.service.RouteService;
import de.onlineferries.model.service.ShipService;
import de.onlineferries.view.RouteView;
import de.onlineferries.view.ShipView;

@ManagedBean
@SessionScoped
public class RouteHandler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{serviceLocatorBean}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
	
	private List<RouteView> routes;
	public List<RouteView> getRoutes() { return routes; }
	
	private RouteView route;
	public RouteView getRoute() { return route; }
	public void setRoute(RouteView route) { this.route = route; }

	private ShipView ship;
	public ShipView getShip() { return ship; }

	public String routes() {
		
		RouteService routeService = serviceLocator.getRouteService();
		routes = routeService.findAllRoutes();
		if (routes.size() > 0)
			route = routes.get(0);
		ship = serviceLocator.getShipService().findShip(route.getRoute_id());
		
		return "success";
	}

	public String back() {
		return "/index.xhtml?faces-redirect=true";
	}

	public Converter getRouteConverter() {
		return new Converter() {

			@Override
			public Object getAsObject(FacesContext context, UIComponent component,
					String value) {
				for (int i = 0; i < routes.size(); i++) {
					RouteView r = routes.get(i);
					if ((new Integer(r.getRoute_id()).toString()).equals(value))
						return r;
				}				
				return null;
			}

			@Override
			public String getAsString(FacesContext context, UIComponent component,
					Object value) {
				return (new Integer(((RouteView)value).getRoute_id())).toString();
			}			
		};
	}

	public void routeChanged(ValueChangeEvent vce) {
		
		System.out.println("**** routeChanged");
		try {
			RouteView route = (RouteView)vce.getNewValue();
			ShipService shipService = serviceLocator.getShipService();
			ship = shipService.findShip(route.getRoute_id());
			System.out.println("***** " + ship.getDescription());
		}
		catch (Exception ex) {
			FacesContext context = FacesContext.getCurrentInstance();
			ResourceBundle rb = context.getApplication().getResourceBundle(context, "error_msg");
			context.addMessage(null, new FacesMessage(rb.getString("route_error")));
			ex.printStackTrace();
		}
	}

}
