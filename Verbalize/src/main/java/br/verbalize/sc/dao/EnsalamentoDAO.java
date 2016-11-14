package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.Ensalamento;

public class EnsalamentoDAO extends DAO<Ensalamento> {

	
	public Ensalamento buscarPorId(long id) {
		return getEM().find(Ensalamento.class, id);
	}

	public List<Ensalamento> listar() {
		Query query = getEM().createQuery("From Ensalamento", Ensalamento.class);
		return query.getResultList();
	}
	
	

}
