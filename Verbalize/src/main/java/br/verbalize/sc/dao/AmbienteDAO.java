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
		Query query = getEM().createQuery("SELECT a FROM Ambiente a", Ambiente.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ambiente> listarParaAutoComplete(String busca) {
		Query query = getEM().createQuery("SELECT a FROM Ambiente a WHERE a.nome LIKE :nome");
		query.setParameter("nome", "%"+busca+"%");
		return query.getResultList();
	}
	
	
	
}
