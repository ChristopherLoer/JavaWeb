
package de.onlineferries.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.onlineferries.entity.Route;
import de.onlineferries.entity.Trip;
import de.onlineferries.view.RouteView;
import de.onlineferries.view.TripView;

public class RouteServiceImpl implements RouteService {

	@Override
	public RouteView findRoute(Integer id) {
		
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		try {
			Route route = em.find(Route.class, id);
			return new RouteView(route.getId(), route.getStart(), route.getDestination());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<RouteView> findAllRoutes() {
		
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		List<RouteView> routesV = null;
		
		try {
			 TypedQuery<Route> query = em.createQuery("from de.onlineferries.entity.Route", Route.class);
			 List<Route> routes = query.getResultList();
			 routesV = new ArrayList<RouteView>();
			 for (Route route : routes)
				 routesV.add(new RouteView(route.getId(), route.getStart(), route.getDestination()));			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
		return routesV;
	}

	@Override
	public List<TripView> findTrips(int route_id) {

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		List<TripView> tripsV = null;
		
		try {
			Route route = em.find(Route.class, route_id);
			List<Trip> trips = route.getTrips();
			tripsV = new ArrayList<TripView>();
			for (int i = 0; i < trips.size(); i++) {
				Trip trip = trips.get(i);
				tripsV.add(new TripView(
					trip.getId(), 
					trip.getDate(), 
					trip.getDeparture(), 
					trip.getArrival(), 
					route_id, 
					trip.getPrice_car(), 
					trip.getPrice_passenger()));
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
		
		return tripsV;
	}

}
