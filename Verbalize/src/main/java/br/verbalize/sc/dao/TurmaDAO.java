package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.verbalize.sc.model.Turma;

public class TurmaDAO extends DAO<Turma> {
	
	
	
	public TurmaDAO() {
	}

	public TurmaDAO(EntityManager EM) {
		super(EM);
	}

	public Turma buscarPorId (long id) {
		return getEM().find(Turma.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> listar() {
		Query query = getEM().createQuery("From Turma", Turma.class);
		return query.getResultList();
	}

}
