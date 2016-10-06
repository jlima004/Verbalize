package br.verbalize.sc.commons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtilTest {
	
	private static EntityManagerFactory EMF;
	private static EntityManager EM;
	private static JpaUtilTest instancia;
	
	private JpaUtilTest(){}
	
	public static JpaUtilTest getInstacia() {
		if (instancia == null) {
			instancia = new JpaUtilTest();
		}
		return instancia;
	}
	
	public static EntityManager getEntityManager() {
		if (EMF == null) {
			EMF = Persistence.createEntityManagerFactory("hsqldb");
		}
		if (EM == null) {
			EM = EMF.createEntityManager();
		}
		return EM;
	}
	
	public void closeEntityManager() {
		if (EM.isOpen()) {
			EM.close();
		}
	}
	
	public void closeFactory() {
		if (EMF.isOpen()) {
			EMF.close();
		}
	}

}
