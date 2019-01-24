package de.onlineferries.controller.managedbeans;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleHandler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String locale;
		
	public String changeLocale() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		locale = params.get("locale");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));
		return null;
	}

	/*
	public void changeLocale(ActionEvent ev) {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		locale = params.get("locale");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));		
	}
*/
	public String getLocale() {
		if (locale == null) {
//			locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale().toString();
			locale="de";
		}
		return locale;
	}
	
	public void setLocale(String locale) {
		this.locale = locale;
	}
}
