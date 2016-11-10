package br.verbalize.sc.rn;

import java.sql.SQLException;
import java.util.List;

import br.verbalize.sc.dao.DAOFactory;
import br.verbalize.sc.model.Turma;
import br.verbalize.sc.model.Perfil;

public class TurmaRN {
 
	public void salvar(Turma turma) throws IllegalArgumentException,Exception {
		if(turma.getProfessor() == null) {
			throw new IllegalArgumentException("é preciso selecionar um Professor");
		}
		if(!turma.getProfessor().getPerfil().equals(Perfil.ROLE_PROFESSOR.toString())){
			throw new IllegalArgumentException("O usuario selecionado não á um professor um Professor");
		}
		
		try {
			DAOFactory.getTurmaDAO().salvar(turma);
		} catch (SQLException e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}
	
	public Turma buscarPorId(Long id) {
		return DAOFactory.getTurmaDAO().buscarPorId(id);
	}
	
	public List<Turma> listar() {
		return DAOFactory.getTurmaDAO().listar();
	}
	
	public void excluir(Turma turma) {
		DAOFactory.getTurmaDAO().excluir((turma.getId()), turma);
	}
	
}
