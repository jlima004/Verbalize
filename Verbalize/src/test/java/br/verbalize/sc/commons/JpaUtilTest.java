package br.verbalize.sc.commons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtilTest {
	
	private EntityManagerFactory EMF;
	private EntityManager EM;
	private static JpaUtilTest instancia;
	
	private JpaUtilTest(){}
	
	public static JpaUtilTest getInstancia() {
		if (instancia == null) {
			instancia = new JpaUtilTest();
		}
		return instancia;
	}
	
	public EntityManagerFactory initEntityManagerFactory() {
		if (this.EMF == null) {
			this.EMF = Persistence.createEntityManagerFactory("hsqldb");
		}
		return this.EMF;
	}
	
	public EntityManager getEntityManager() {
		if (this.EMF != null && this.EMF.isOpen() && (this.EM == null || !this.EM.isOpen())) {
			this.EM = this.EMF.createEntityManager();
		}
		return this.EM;
	}
	
	public void closeEntityManager() {
		if (this.EM != null && this.EM.isOpen()) {
			this.EM.close();
		}
		this.EM = null;
	}
	
	public void closeEntityManagerFactory() {
		if (this.EMF != null && this.EMF.isOpen()) {
			this.EMF.close();
		}
		this.EMF = null;
	}
	
	public void beginSession() {
		this.EM.getTransaction().begin();
	}
	
	public void endSession() {
		try {
			this.EM.getTransaction().commit();
		} catch (Exception e) {
			this.EM.getTransaction().rollback();
			e.printStackTrace();
		} 
	}

}
