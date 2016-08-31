package br.verbalize.sc.rn;

import java.util.List;

import br.verbalize.sc.dao.ArquivoDAO;
import br.verbalize.sc.model.Arquivo;

public class ArquivoRN {
	
	private ArquivoDAO dao;
	
	public ArquivoRN() {
		dao = new ArquivoDAO();
	}
	
	public void adicionar(Arquivo arquivo) throws Exception {
		try {
			dao.salvar(arquivo);
		} catch (Exception e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
		
	}
	
	public List<Arquivo> listarArquivosPorTurma(Long idTurma) {
		return dao.listarArquivosPorTurma(idTurma);
	}
	
	public Arquivo buscarPorId(long idArquivo) {
		return dao.buscarPorId(idArquivo);
	}
	
	public void excluir(Arquivo arquivo) {
		dao.excluir(arquivo);
	}

}
