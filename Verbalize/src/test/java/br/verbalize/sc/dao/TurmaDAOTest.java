package br.verbalize.sc.dao;

import java.sql.SQLException;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.verbalize.sc.commons.JpaUtilTest;
import br.verbalize.sc.model.Pessoa;
import br.verbalize.sc.model.Turma;

public class TurmaDAOTest {
	
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
	public void entityManagerByTurmaDaoIsNotNullTest() {
		Assert.assertNotNull(EM);
	}
	
	
	/*private Pessoa salvaProfessor() throws SQLException {
		PessoaDAO dao = new PessoaDAO(EM);
		Pessoa pessoaSave = new Pessoa(1l, "Teste da silva", "dasilva@senai.com", "123456788912", "000000000000", "1234", "ROLE_PROFESSOR");
		
		JpaUtilTest.getInstancia().beginSession();
		
		dao.salvar(pessoaSave);
		
		JpaUtilTest.getInstancia().endSession();
		
		return dao.buscarPorId(1l);
	}*/
	
	/*------------------------------------------- Não salva a turma, com merge ou persist  -------------------------------- */
	
	/*@Test
	public void SalvaTurmaTest() throws SQLException {
		TurmaDAO dao = new TurmaDAO(EM);
		
		Date data = new Date();
		
//		Pessoa professor = new Pessoa(1l, "Teste da silva", "dasilva@senai.com", "123456788912", "000000000000", "1234", "ROLE_PROFESSOR");
		
		Turma turmaSave = new Turma(1l, "Turma Piloto", data, data, 56.56f, new Pessoa(1l, "Teste da silva", "dasilva@senai.com", "123456788912", "000000000000", "1234", "ROLE_PROFESSOR"));
		
		System.out.println(turmaSave);
		
		JpaUtilTest.getInstancia().beginSession();
		
		dao.salvar(turmaSave);
		
		JpaUtilTest.getInstancia().endSession();
		
		Turma turmaRecuperada = dao.buscarPorId(1l);
		
		Assert.assertTrue(turmaSave.equals(turmaRecuperada));
	}*/

}
