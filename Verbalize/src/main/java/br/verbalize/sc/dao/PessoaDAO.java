package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.verbalize.sc.model.Perfil;
import br.verbalize.sc.model.Pessoa;

public class PessoaDAO extends DAO<Pessoa> {
	
	public PessoaDAO() {
		
	}
	
	public PessoaDAO(EntityManager EM) {
		super(EM);
	}

	public Pessoa buscarPorId(long id) {
		return getEM().find(Pessoa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		Query query = getEM().createQuery("From Pessoa", Pessoa.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listarProfessores() {
		Query query = getEM().createQuery(
				"From Pessoa WHERE perfil = :perfil", Pessoa.class);
		query.setParameter("perfil", Perfil.ROLE_PROFESSOR);
		return query.getResultList();
	}
	
	public Pessoa buscaPorEmail(String email) {
		Query query = getEM().createQuery(
				"From Pessoa p WHERE p.email = :email", Pessoa.class);
		query.setParameter("email", email);
		
		try {
			return (Pessoa) query.getSingleResult();
			
		} catch (NoResultException exception) {
			return null;
		}
	}

}
