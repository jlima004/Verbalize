package br.verbalize.sc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.Agenda;
import br.verbalize.sc.model.Ensalamento;

public class EnsalamentoDAO extends DAO<Ensalamento> {

	
	public Ensalamento buscarPorId(long id) {
		return getEM().find(Ensalamento.class, id);
	}

	public List<Ensalamento> listar() {
		Query query = getEM().createQuery("From Ensalamento", Ensalamento.class);
		return query.getResultList();
	}
	
	public List<Agenda> retornaAgenda( long aluno) {
		Query query = getEM().createNativeQuery("SELECT p.nmPessoa, e.dia, e.inicio, e.fim, a.nome AS ambiente"
				+"FROM pessoa AS p"
				+"INNER JOIN turma_pessoa as tp"
				+"ON p.id=tp.alunosParaMatricular_id"
				+"INNER JOIN turma AS t"
				+"ON t.id=tp.Turma_id"
				+"INNER JOIN ensalamento AS e"
				+"ON e.turma_id=t.id"
				+"INNER JOIN ambiente AS a"
				+"ON a.id=e.ambiente_id"
				+"WHERE p.id = :aluno");
		query.setParameter("aluno", aluno);
		List<Object[]> vetor = query.getResultList();
		List<Agenda> agendas = new ArrayList<Agenda>();
		for(Object[] o:vetor) {
			Agenda a = new Agenda();
			a.setNmPessoa((String) o[0]);
			a.setDia((Date) o[1]);
			a.setInicio((Date) o[2]);
			a.setFim((Date) o[3]);
			a.setAmbiente((String) o[4]);
			
			agendas.add(a);
			
		}
		return agendas;
	}
	

}
