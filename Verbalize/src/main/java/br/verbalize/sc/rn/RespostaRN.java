package br.verbalize.sc.rn;

import java.util.List;

import br.verbalize.sc.dao.RespostaDAO;
import br.verbalize.sc.model.Resposta;

public class RespostaRN {
	
	private RespostaDAO dao;
	
	public RespostaRN() {
		dao = new RespostaDAO();
	}
	
	public void salvar(Resposta resposta) throws Exception {
		try {
			dao.salvar(resposta);
		} catch (Exception e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
		
	}
	
	public Resposta buscarPorId(long id) {
		return dao.buscarPorId(id);
	}
	
	public List<Resposta> listar() {
		return dao.listar();
	}
	
	public void excluir(Resposta resposta) {
		dao.excluir(resposta);
	}

}
