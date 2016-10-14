package br.verbalize.sc.rn;

import java.util.List;

import br.verbalize.sc.dao.DAOFactory;
import br.verbalize.sc.model.Ambiente;
 
public class AmbienteRN {
	
	public void salvar(Ambiente ambiente) throws Exception {
		try {
			DAOFactory.getAmbienteDAO().salvar(ambiente);
		} catch (Exception e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}
	
	public Ambiente buscarPorId(long id) {
		return DAOFactory.getAmbienteDAO().buscarPorId(id);
	}
	
	public List<Ambiente> listar() {
		return DAOFactory.getAmbienteDAO().listar();
	}
	
	public void excluir(Ambiente ambiente) {
		DAOFactory.getAmbienteDAO().excluir(ambiente.getId(), ambiente);
	}
	
	public List<Ambiente> listarParaAutoComplete(String busca) {
		return DAOFactory.getAmbienteDAO().listarParaAutoComplete(busca);
	}
	
}
