package br.verbalize.sc.rn;

import java.util.ArrayList;
import java.util.List;

import br.verbalize.sc.dao.DAOFactory;
import br.verbalize.sc.json.EnsalamentoJson;
import br.verbalize.sc.model.Ensalamento;

public class EnsalamentoRN {
	
	public void salvar(Ensalamento ensalamento) throws Exception {
		try {
			DAOFactory.getEnsalamentoDAO().salvar(ensalamento);
		} catch (Exception e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}
	
	public Ensalamento buscarPorId(long id) {
		return DAOFactory.getEnsalamentoDAO().buscarPorId(id);
	}
	
	public List<Ensalamento> listar(){
		return DAOFactory.getEnsalamentoDAO().listar();
	}
	
	public void excluir(Ensalamento ensalamento) {
		DAOFactory.getEnsalamentoDAO().excluir(ensalamento.getId(), ensalamento);
	}
	
	public List<EnsalamentoJson> listarEnsalamentoParaJson() {
		List<EnsalamentoJson> ensalamentosJson = new ArrayList<EnsalamentoJson>();
		List<Ensalamento> ensalamentosCarregados = DAOFactory.getEnsalamentoDAO().listar();
		for (Ensalamento e : ensalamentosCarregados) {
			EnsalamentoJson ej = new EnsalamentoJson();
			ej.setDia(e.getDia());
			ej.setInicio(e.getInicio());
			ej.setFim(e.getFim());
			ej.setAmbiente(e.getAmbiente());
			ej.setTurma(e.getTurma());
		}
		return ensalamentosJson;
	}

}
