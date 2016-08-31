package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.Resposta;


public class RespostaDAO extends DAO<Resposta> {
	
	public Resposta buscarPorId(long id) {
		return getEM().find(Resposta.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Resposta> listar() {
		Query query = getEM().createQuery("From Resposta", Resposta.class);
		return query.getResultList();
	}

}
