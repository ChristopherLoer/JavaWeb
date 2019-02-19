package de.onlineferries.model.service;

public interface NewCustomerService {
	boolean newCustomer(String password, String firstname, String name, String city, String street, String zipcode, String email, Integer bank_id, Integer account_nr);
}
