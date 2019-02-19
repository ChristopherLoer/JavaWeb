package de.onlineferries.model.service;

import java.util.List;

import de.onlineferries.view.CustomerView;
import de.onlineferries.view.ReservationView;
import de.onlineferries.view.ShipCabinView;

public interface ReservationService {

	public double getReservationPrice(int ship_id, List<ShipCabinView> shipCabins, int cars, int travellers);

	public boolean isAvailable(int ship_id, List<ShipCabinView> shipCabins, int cars, int travellers);

	public void insertReservation(ReservationView reservationView);

	public List<ReservationView> getReservationsForCustomer(CustomerView cust);

}
