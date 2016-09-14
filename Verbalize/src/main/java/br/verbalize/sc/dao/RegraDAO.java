package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.Regra;

public class RegraDAO extends DAO<Regra> {

	@Override
	public Regra buscarPorId(long id) {
		return getEM().find(Regra.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Regra> listar() {
		Query query = getEM().createQuery("SELECT r FROM Regra r", Regra.class);
		return query.getResultList();
	}

}
