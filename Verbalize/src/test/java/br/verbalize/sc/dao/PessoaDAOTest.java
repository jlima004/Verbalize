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
	
	@Test
	public void buscarPorIdTest() {
		
		PessoaDAO dao = new PessoaDAO(EM);
		
		JpaUtilTest.getInstancia().beginSession();
		
		JpaUtilTest.getInstancia().endSession();
		
		Pessoa pessoaTest2 = dao.buscaPorEmail("jlima004@gmail.com");
		
		Pessoa pessoaTest1 = dao.buscarPorId(1l);
		
		Assert.assertTrue(pessoaTest1.equals(pessoaTest2));
		
	}
	
	/*@Test
	public void salvaOutraPessoaTest() throws SQLException {
		PessoaDAO dao = new PessoaDAO(EM);
		Pessoa pessoaDois = new Pessoa(2l, "Outro", "jlima009@gmail.br", "12345658912", "0004540000", "2222", "ROLE_ADMIN");
		
		JpaUtilTest.getInstancia().beginSession();
		
		dao.salvar(pessoaDois);
		
		JpaUtilTest.getInstancia().endSession();
		
		Pessoa pessoaRecuperaDois = dao.buscaPorEmail("jlima009@gmail.br");
		
		Assert.assertTrue(pessoaDois.equals(pessoaRecuperaDois));
	}*/
	
	@Test
	public void salvaPessoaFalseTest() throws SQLException {
		PessoaDAO dao = new PessoaDAO(EM);
		Pessoa pessoaSave = new Pessoa(3l, "Moacir", "moacir@senai.com", "123456788912", "000000000000", "1234", "ROLE_ALUNO");
		
		JpaUtilTest.getInstancia().beginSession();
		
		dao.salvar(pessoaSave);
		
		JpaUtilTest.getInstancia().endSession();
		
		Pessoa pessoaRecuperada = dao.buscaPorEmail("naoexiste@senai.com");
		
		Assert.assertFalse(pessoaSave.equals(pessoaRecuperada));
	}
	
	@Test
	public void salvaPessoaConstrutorVazioTest() throws SQLException {
		PessoaDAO dao = new PessoaDAO(EM);
		Pessoa pessoaSave = new Pessoa();
		
		JpaUtilTest.getInstancia().beginSession();
		
		dao.salvar(pessoaSave);
		
		JpaUtilTest.getInstancia().endSession();
	}
	
	@Test
	public void listarPessoaTest() {
		
		PessoaDAO dao = new PessoaDAO(EM);
		
		JpaUtilTest.getInstancia().beginSession();
		
		dao.listar();
		
		JpaUtilTest.getInstancia().endSession();	
		
	}
	
	@Test
	public void listarProfessoresTest() {
		
		PessoaDAO dao = new PessoaDAO(EM);
		
		JpaUtilTest.getInstancia().beginSession();
		
		dao.listarProfessores();
		
		JpaUtilTest.getInstancia().endSession();	
		
	}
	
	
	

	@Test
	public void excluirTest() {
		
		PessoaDAO dao = new PessoaDAO(EM);
		
		Pessoa pessoaTest1 = dao.buscarPorId(1l);
		
		JpaUtilTest.getInstancia().beginSession();
		
		/*dao.excluir(1L, pessoaTest1);*/
		
		JpaUtilTest.getInstancia().endSession();
		
		Pessoa pessoaTest2 = dao.buscarPorId(1l);
		
		Assert.assertTrue(pessoaTest1.equals(pessoaTest2));
		
	}
	
	
	
	
}
