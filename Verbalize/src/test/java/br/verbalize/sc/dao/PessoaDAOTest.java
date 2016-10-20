package br.verbalize.sc.dao;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.verbalize.sc.commons.JpaUtilTest;
import br.verbalize.sc.model.Pessoa;



public class PessoaDAOTest {
	private EntityManager EM;
	
	@AfterClass
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
	
	/*@Test
	public void salvaPessoaTest() {
		PessoaDAO dao = new PessoaDAO(EM);
		Pessoa pessoaSave = new Pessoa(1l, "ROLE_ADMINISTRADOR", "João", "joao@joao.com.br", 
				"123456abc", "rua joão da silva, 2424", "000.000.000-00", new Date(), null, null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(pessoaSave);
		JpaUtilTest.getInstancia().endSession();
		
		Pessoa pessoaRecuperada = dao.buscaPorEmail("joao@joao.com.br");
		
		Assert.assertTrue(pessoaSave.equals(pessoaRecuperada));
	}*/
	
	
	
}
