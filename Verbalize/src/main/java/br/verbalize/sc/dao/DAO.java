package br.verbalize.sc.dao;

import javax.persistence.EntityManager;

import br.verbalize.sc.commons.JpaUtil;

import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {
	
	private EntityManager EM = null;
	
	public DAO() {
		super();
	}
	
	public DAO(EntityManager EM) {
		this.EM = EM;
	}
	
	protected EntityManager getEM() {
		if (this.EM == null) {
			return JpaUtil.getEntityManager();
		}
		return this.EM;
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
