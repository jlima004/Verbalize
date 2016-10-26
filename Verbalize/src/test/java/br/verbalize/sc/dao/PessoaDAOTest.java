package br.verbalize.sc.dao;


import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.verbalize.sc.commons.JpaUtilTest;
import br.verbalize.sc.model.Pessoa;



public class PessoaDAOTest {
	private EntityManager EM;
	
	@BeforeClass
	public static void initClass() {
		JpaUtilTest.getInstancia().initEntityManagerFactory();
	}
	
	@AfterClass
	public static void finishClass() {
		JpaUtilTest.getInstancia().closeEntityManagerFactory();
	}

	@Before
	public void initTest() {
		EM = JpaUtilTest.getInstancia().getEntityManager();
	}

	@After
	public void finishTest() {
		JpaUtilTest.getInstancia().closeEntityManager();
	}

	@Test
	public void entityManagerByPessoaDaoIsNotNullTest() {
		Assert.assertNotNull(EM);
	}

	@Test
	public void entityManagerByPessoaDaoIsNullTest() {
		EM = null;
		Assert.assertNull(EM);
	}
	
	@Test
	public void salvaPessoaTest() throws SQLException {
		PessoaDAO dao = new PessoaDAO(EM);
		Pessoa pessoaSave = new Pessoa(1l, "Jefferson", "jlima004@gmail.com", "123456788912", "000000000000", "1234", "ROLE_ADMIN");
		
		JpaUtilTest.getInstancia().beginSession();
		
		dao.salvar(pessoaSave);
		
		JpaUtilTest.getInstancia().endSession();
		
		Pessoa pessoaRecuperada = dao.buscaPorEmail("jlima004@gmail.com");
		
		Assert.assertTrue(pessoaSave.equals(pessoaRecuperada));
	}
	
	
}
