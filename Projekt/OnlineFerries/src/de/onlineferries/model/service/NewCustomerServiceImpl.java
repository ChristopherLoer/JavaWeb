package de.onlineferries.model.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import de.onlineferries.entity.Customer;

public class NewCustomerServiceImpl implements NewCustomerService {

	@Override
	public boolean newCustomer(String password, String firstname, String name, String city, String street,
			String zipcode, String email, Integer bank_id, Integer account_nr) {

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		try {
			em.getTransaction().begin();
			Customer customer = new Customer();
			customer.setName(name);
			customer.setPassword(password);
			customer.setFirstname(firstname);
			customer.setCity(city);
			customer.setStreet(street);
			customer.setZipcode(zipcode);
			customer.setEmail(email);
			customer.setBank_id(bank_id);
			customer.setAccount_nr(account_nr);
			em.persist(customer);
			em.getTransaction().commit();
			System.out.println("persist of customer " + name + " successful");
		} catch (NoResultException ex) {
		} catch (Exception ex) {
			System.out.println("ERROR: persist of new customer " + name + " not successful");
			ex.printStackTrace();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	@Override
	public boolean updateCustomer(String password, String firstname, String name, String city, String street,
			String zipcode, String email, Integer bank_id, Integer account_nr) {

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		try {
			em.getTransaction().begin();
			Customer customer = em.find(Customer.class, account_nr);
			customer.setName(name);
			customer.setPassword(password);
			customer.setFirstname(firstname);
			customer.setCity(city);
			customer.setStreet(street);
			customer.setZipcode(zipcode);
			customer.setEmail(email);
			customer.setBank_id(bank_id);
			em.persist(customer);
			em.getTransaction().commit();
			System.out.println("persist of updated customer " + name + " successful");
		} catch (NoResultException ex) {
		} catch (Exception ex) {
			System.out.println("ERROR: persist of customer " + name + " not successful");
			ex.printStackTrace();
			return false;
		} finally {
			em.close();
		}
		return true;
	}
}
