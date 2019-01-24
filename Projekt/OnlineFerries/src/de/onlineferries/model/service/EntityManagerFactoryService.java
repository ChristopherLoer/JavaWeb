package de.onlineferries.model.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryService {

	private static EntityManagerFactory emf;
	
	private EntityManagerFactoryService() {}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("OnlineFerries");
		return emf;
	}
	
	@Override
	protected void finalize() {
		if (emf != null)
			emf.close();
	}
	
}
