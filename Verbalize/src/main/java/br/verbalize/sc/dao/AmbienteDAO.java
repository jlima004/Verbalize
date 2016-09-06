package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.Ambiente;

public class AmbienteDAO extends DAO<Ambiente> {

	
	public Ambiente buscarPorId(long id) {
		return getEM().find(Ambiente.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Ambiente> listar() {
		Query query = getEM().createQuery("From Ambiente", Ambiente.class);
		return query.getResultList();
	}
	
}
