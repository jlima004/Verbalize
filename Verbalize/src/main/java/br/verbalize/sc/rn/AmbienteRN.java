package br.verbalize.sc.rn;

import java.util.List;

import br.verbalize.sc.dao.AmbienteDAO;
import br.verbalize.sc.model.Ambiente;
 
public class AmbienteRN {
	
	private AmbienteDAO dao;

	public AmbienteRN() {
		dao = new AmbienteDAO();
	}
	
	public void salvar(Ambiente ambiente) throws Exception {
		try {
			dao.salvar(ambiente);
		} catch (Exception e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}
	
	public Ambiente buscarPorId(long id) {
		return dao.buscarPorId(id);
	}
	
	public List<Ambiente> listar() {
		return dao.listar();
	}
	
	public void excluir(Ambiente ambiente) {
		dao.excluir(ambiente);
	}
	
}
