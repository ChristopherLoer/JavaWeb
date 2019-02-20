package de.onlineferries.model.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import de.onlineferries.entity.Customer;
import de.onlineferries.view.CustomerView;

public class LoginServiceImpl implements LoginService {

	@Override
	public CustomerView login(String username, String password) {

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		CustomerView customerView = null;

		try {
			Query q = em.createNamedQuery("loginCustomer", Customer.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			Customer customer = (Customer) q.getSingleResult();
			customerView = new CustomerView(customer.getId(), customer.getFirstname(), customer.getName(),
					customer.getStreet(), customer.getZipcode(), customer.getCity(), customer.getEmail(),
					customer.getAccount_nr(), customer.getBank_id(), customer.getPassword());

		} catch (NoResultException ex) {
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

		return customerView;
	}

	@Override
	public CustomerView getData(String username) {
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		CustomerView customerView = null;

		try {
			Query q = em.createNamedQuery("dataCustomer", Customer.class);
			q.setParameter("username", username);
			Customer customer = (Customer) q.getSingleResult();
			customerView = new CustomerView(customer.getId(), customer.getFirstname(), customer.getName(),
					customer.getStreet(), customer.getZipcode(), customer.getCity(), customer.getEmail(),
					customer.getAccount_nr(), customer.getBank_id(), customer.getPassword());

		} catch (NoResultException ex) {
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

		return customerView;
	}

}
