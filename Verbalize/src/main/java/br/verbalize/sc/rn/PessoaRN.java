package br.verbalize.sc.rn;

import java.util.List;

import br.verbalize.sc.dao.PessoaDAO;
import br.verbalize.sc.model.Pessoa;

public class PessoaRN {
	
	private PessoaDAO dao;
	
	public PessoaRN() {
		dao = new PessoaDAO();
	}
	
	public void salvar(Pessoa pessoa) throws Exception {
		try {
			dao.salvar(pessoa);
		} catch (Exception e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
		
	}
	
	public Pessoa buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	public List<Pessoa> listar() {
		return dao.listar();
	}
	
	public List<Pessoa> ListarProfessores() {
		return dao.listarProfessores();
	}
	
	public void excluir(Pessoa pessoa) {
		dao.excluir(pessoa.getId(), pessoa);
	}
	
	public Pessoa buscarPorEmail(String email) {
		return dao.buscaPorEmail(email);
	}
	
}
