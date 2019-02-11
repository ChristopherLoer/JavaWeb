package de.onlineferries.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.onlineferries.entity.Cabin;
import de.onlineferries.entity.CabinReservation;
import de.onlineferries.entity.Customer;
import de.onlineferries.entity.Reservation;
import de.onlineferries.entity.Route;
import de.onlineferries.entity.Travellers;
import de.onlineferries.entity.Trip;
import de.onlineferries.view.CustomerView;
import de.onlineferries.view.ReservationView;
import de.onlineferries.view.RouteView;
import de.onlineferries.view.ShipCabinView;
import de.onlineferries.view.TravellerView;
import de.onlineferries.view.TripView;

public class ReservationServiceImpl implements ReservationService {

	@Override
	public double getReservationPrice(int trip_id, List<ShipCabinView> shipCabins, int cars, int travellers) {

		double reservation_price = 0;

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		try {

			Trip trip = em.find(Trip.class, trip_id);

			reservation_price += cars * trip.getPrice_car();
			reservation_price += (travellers + 1) * trip.getPrice_passenger();
			for (ShipCabinView shipCabin : shipCabins) {
				if (shipCabin.getRes_count() > 0) {
					reservation_price += shipCabin.getRes_count() * shipCabin.getPrice();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return reservation_price;
	}

	@Override
	public boolean isAvailable(int trip_id, List<ShipCabinView> shipCabins, int cars, int travellers) {

		boolean isAvailable = true;

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		List<ReservationView> reservationV = null;
		try {

			Trip trip = em.find(Trip.class, trip_id);

			TypedQuery<Reservation> query = em.createQuery("from de.onlineferries.entity.Reservation",
					Reservation.class);
			List<Reservation> reservations = query.getResultList();

			TypedQuery<Travellers> query2 = em.createQuery("from de.onlineferries.entity.Travellers", Travellers.class);
			List<Travellers> travellersList = query2.getResultList();

			for (Travellers traveller : travellersList) {
				if (traveller.getReservation().getTrip().getId() != trip_id) {
					travellersList.remove(traveller);
				}
			}

			for (Reservation reservation : reservations) {
				if (reservation.getTrip().getId() != trip_id) {
					reservations.remove(reservation);
				}
			}

			int travellersOnShip = travellersList.size();
			int carsOnShip = 0;
			for (Reservation reservation : reservations) {
				carsOnShip += reservation.getCars();
			}

			if (trip.getRoute().getShip().getPassengers() < travellersOnShip + travellers) {
				return false;
			}

			if (trip.getRoute().getShip().getCars() < carsOnShip + cars) {
				return false;
			}

			for (ShipCabinView shipCabin : shipCabins) {
				if (shipCabin.getRes_count() > 0) {
					int CabinsOnShip = 10;// TODO aus Reservierungen berechnen
					if (trip.getRoute().getShip().getShipCabin() + cars < CabinsOnShip) {
						return false;
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return true;
	}

	@Override
	public void insertReservation(ReservationView reservationView) {

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();

			Reservation reservation = new Reservation();

			CustomerView customerView = reservationView.getCustomer();
			Customer customer = null;
			if (customerView.getCustomer_id() != 0) {
				customer = em.find(Customer.class, customerView.getCustomer_id());
				customer.getReservations().add(reservation);
			} else {
				customer = new Customer();
				customer.setName(customerView.getLastname());
				customer.setFirstname(customerView.getFirstname());
				customer.setStreet(customerView.getStreet());
				customer.setZipcode(customerView.getZip());
				customer.setCity(customerView.getCity());
				customer.setEmail(customerView.getEmail());
				customer.setBank_id(customerView.getBank_id());
				customer.setAccount_nr(customerView.getAccount_no());
				customer.setPassword(customerView.getEmail());

				HashSet<Reservation> reservations = new HashSet<Reservation>();
				reservations.add(reservation);
				customer.setReservations(reservations);
			}
			reservation.setCustomer(customer);

			Trip trip = em.find(Trip.class, reservationView.getTrip().getTrip_id());
			reservation.setTrip(trip);

			reservation.setCars(reservationView.getCars());

			if (reservationView.getShipCabins() != null) {
				List<CabinReservation> res_cabins = new ArrayList<CabinReservation>();
				for (int i = 0; i < reservationView.getShipCabins().size(); i++) {
					ShipCabinView shipCabinView = reservationView.getShipCabins().get(i);
					if (shipCabinView.getRes_count() > 0) {
						CabinReservation cabinReservation = new CabinReservation();
						Cabin cabin = em.find(Cabin.class, shipCabinView.getCabin_id());
						cabinReservation.setCabin(cabin);
						cabinReservation.setCount(shipCabinView.getRes_count());
						cabinReservation.setReservation(reservation);
						res_cabins.add(cabinReservation);
						System.out.println("***** Kabine hinzugef�gt: " + cabin.getId());
					}
				}
				reservation.setCabins(res_cabins);
			}

			if (reservationView.getTravellerNames() != null) {
				List<Travellers> tr = new ArrayList<Travellers>();
				for (int i = 0; i < reservationView.getTravellerNames().size(); i++) {
					Travellers traveller = new Travellers(reservationView.getTravellerNames().get(i).getName());
					traveller.setReservation(reservation);
					tr.add(traveller);
				}
				reservation.setTravellers(tr);
			}

			em.persist(reservation);

			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

}