package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.Arquivo;

public class ArquivoDAO extends DAO<Arquivo> {
	
	@SuppressWarnings("unchecked")
	public List<Arquivo> listarArquivosPorTurma(Long turmaId) {
		Query query = getEM().createQuery(
				"From Arquivo i Where i.turma.id = :turmaId ", Arquivo.class);
		query.setParameter("turmaId", turmaId);
		return query.getResultList();
	}
	
	public Arquivo buscarPorId(long idArquivo) {
		return getEM().find(Arquivo.class, idArquivo);
	}

	
	public List<Arquivo> listar() {
		return null;
	}

	
}
