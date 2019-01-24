package de.onlineferries.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import de.onlineferries.entity.Route;
import de.onlineferries.entity.Ship;
import de.onlineferries.entity.ShipCabin;
import de.onlineferries.view.ShipCabinView;
import de.onlineferries.view.ShipView;

public class ShipServiceImpl implements ShipService {

	@Override
	public ShipView findShip(int route_id) {

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		try {
			Route route = em.find(Route.class, route_id);
			Ship ship = route.getShip();
			return new ShipView(ship.getId(), ship.getDescription(), ship.getCars(), ship.getPassengers());
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
	public List<ShipCabinView> findAllShipCabins(int ship_id) {
		
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		try {
			Ship ship = em.find(Ship.class, ship_id);
			List<ShipCabin> shipCabins = ship.getShipCabin();
			
			List<ShipCabinView> shipCabinView = new ArrayList<ShipCabinView>();
			for(ShipCabin shipCabin : shipCabins) {
				shipCabinView.add(new ShipCabinView(shipCabin.getCabin().getId(), shipCabin.getCabin().getDescription(), 
					shipCabin.getCabin().getPassengers(), shipCabin.getCount(), 0, shipCabin.getPrice()));
			}
			return shipCabinView;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
		return null;
	}
}
