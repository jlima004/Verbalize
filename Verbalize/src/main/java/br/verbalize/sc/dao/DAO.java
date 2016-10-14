package br.verbalize.sc.dao;

import javax.persistence.EntityManager;

import br.verbalize.sc.commons.JpaUtil;

import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {

	protected EntityManager getEM() {
		return JpaUtil.getEntityManager();
	}
	
	public abstract T buscarPorId(long id);
	public abstract List<T> listar();
	
	public void salvar(T object) throws SQLException {
		getEM().merge(object);
	}
	
	public void excluir(Long id, T object) {
		getEM().remove(getEM().getReference(object.getClass(), id));
	}

}
