package de.onlineferries.controller.events;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class SessionPhaseListener implements PhaseListener{

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		// do nothing
	}

	@Override
	public void beforePhase(PhaseEvent event) {	
		
		FacesContext facesContext = event.getFacesContext();
//		String currentPage = facesContext.getViewRoot().getViewId();
//		boolean isLoginPage = false;
//		if (currentPage != null) {
//			isLoginPage = currentPage.lastIndexOf("login.xhtml") > -1;
//		}
		 
		ExternalContext context = facesContext.getExternalContext();
		HttpSession session = (HttpSession)context.getSession(false);
		if (session == null) {
			Application app = facesContext.getApplication();
			ViewHandler viewHandler = app.getViewHandler();
			UIViewRoot view = viewHandler.createView(facesContext, "/index.xhtml");
			facesContext.setViewRoot(view);
			facesContext.renderResponse();
			try {
				viewHandler.renderView(facesContext, view);
				facesContext.responseComplete();
			} catch(Throwable t){
				throw new FacesException("Session timed out", t);
			}	
		}		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}

