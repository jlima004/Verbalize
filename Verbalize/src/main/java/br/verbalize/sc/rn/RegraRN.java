package br.verbalize.sc.rn;

import java.util.List;

import br.verbalize.sc.dao.DAOFactory;
import br.verbalize.sc.model.Regra;

public class RegraRN {
	
	public void salvar(Regra regra) throws Exception {
		try {
			DAOFactory.getRegraDAO().salvar(regra);
		} catch (Exception e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}
	
	public Regra buscarPorId(long id) {
		return DAOFactory.getRegraDAO().buscarPorId(id);
	}
	
	public List<Regra> listar() {
		return DAOFactory.getRegraDAO().listar();
	}
	
	public void excluir(Regra regra) {
		DAOFactory.getRegraDAO().excluir(regra);
	}

}
