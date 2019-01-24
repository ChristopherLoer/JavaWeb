package de.onlineferries.controller.managedbeans;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import de.onlineferries.model.service.LoginService;
import de.onlineferries.view.CustomerView;

@ManagedBean
@SessionScoped
public class LoginHandler implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private CustomerView customer;

	@ManagedProperty("#{serviceLocatorBean}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
		
	public String login() {
		LoginService loginService = serviceLocator.getLoginService();
		customer = loginService.login(username, password);
		if (customer == null)
			return "retry";
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public CustomerView getCustomer() { return customer; }
	public void setCustomer(CustomerView customer) { this.customer = customer; }
	
	public void validateUsername(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
			
		String v = (String)value;
		if (v == null || v.length() < 3 || v.length() > 50) {
			ResourceBundle rb = context.getApplication().getResourceBundle(context, "msg");
			throw new ValidatorException(new FacesMessage(rb.getString("onlineferries_login_form_invalid_username")));

		}
	}

	public void validatePassword(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
			
		String v = (String)value;
		if (v == null || v.length() < 3 || v.length() > 50) {
			ResourceBundle rb = context.getApplication().getResourceBundle(context, "msg");
			throw new ValidatorException(new FacesMessage(rb.getString("onlineferries_login_form_invalid_password")));
		}
	}
}
