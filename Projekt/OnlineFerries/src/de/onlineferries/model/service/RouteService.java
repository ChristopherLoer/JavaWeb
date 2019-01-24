package de.onlineferries.model.service;

import java.util.List;

import de.onlineferries.view.RouteView;
import de.onlineferries.view.TripView;

public interface RouteService {

	public RouteView findRoute(Integer id);
	public List<RouteView> findAllRoutes();
	public List<TripView> findTrips(int route_id);
	
}
