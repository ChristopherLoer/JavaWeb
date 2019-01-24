package de.onlineferries.controller.events;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
   
public class MyPhaseListenerDemo implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent pe) {
		System.out.println("After Phase: " + pe.getPhaseId());
		System.out.println("View-Id: " + FacesContext.getCurrentInstance().getViewRoot().getViewId());
	}
 
	@Override
	public void beforePhase(PhaseEvent pe) {
		System.out.println("Before Phase: " + pe.getPhaseId());	
	}

	@Override
	public PhaseId getPhaseId() {		
		return PhaseId.ANY_PHASE;
	}

}
