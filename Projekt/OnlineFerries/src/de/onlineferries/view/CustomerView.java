package de.onlineferries.view;

import java.io.Serializable;

public class CustomerView implements Serializable {

	private static final long serialVersionUID = 1L;

	private int customer_id;
	private String firstname;
	private String lastname;
	private String street;
	private String zip;
	private String city;
	private String email;
	private int account_nr;
	private int bank_id;
	private String password;

	public CustomerView() {}
	
	public CustomerView(int customer_id, String firstname, String lastname,
			String street, String zip, String city, String email, int account_nr, int bank_id, String password) {
		super();
		this.customer_id = customer_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.email = email;
		this.account_nr = account_nr;
		this.bank_id = bank_id;
		this.password = password;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAccount_no() {
		return account_nr;
	}

	public void setAccount_no(int account_nr) {
		this.account_nr = account_nr;
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
