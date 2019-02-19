package de.onlineferries.controller.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import de.onlineferries.model.service.NewCustomerService;

@ManagedBean
@SessionScoped
public class NewCustomerHandler implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String password;
	private String firstname;
	private String name;
	private String city;
	private String street;
	private String zipcode;
	private String email;
	private Integer account_nr;
	private Integer bank_id;

	@ManagedProperty("#{serviceLocatorBean}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
		
	public String newCustomer() {
		NewCustomerService newCustomerService = serviceLocator.getNewCustomerService();
		
		if (newCustomerService.newCustomer(password, firstname, name, city, street, zipcode, email, bank_id, account_nr))
			return "success";
		return "retry";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getAccount_nr() {
		return account_nr;
	}
	
	public void setAccount_nr(Integer account_nr) {
		this.account_nr = account_nr;
	}
	
	public Integer getBank_id() {
		return bank_id;
	}
	
	public void setBank_id(Integer bank_id) {
		this.bank_id = bank_id;
	}
}
