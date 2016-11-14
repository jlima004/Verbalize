package br.verbalize.sc.rn;

import java.util.List;

import br.verbalize.sc.dao.DAOFactory;
import br.verbalize.sc.model.Pessoa;

public class PessoaRN {
	
	/*private PessoaDAO dao;
	
	public PessoaRN() {
		dao = new PessoaDAO();
	}*/
	
	public void salvar(Pessoa pessoa) throws Exception {
		try {
			DAOFactory.getPessoaDAO().salvar(pessoa);
		} catch (Exception e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
		
	}
	
	public Pessoa buscarPorId(Long id) {
		return DAOFactory.getPessoaDAO().buscarPorId(id);
	}
	
	public List<Pessoa> listar() {
		return DAOFactory.getPessoaDAO().listar();
	}
	
	public List<Pessoa> ListarProfessores() {
		return DAOFactory.getPessoaDAO().listarProfessores();
	}
	
	public void excluir(Pessoa pessoa) {
		DAOFactory.getPessoaDAO().excluir(pessoa.getId(), pessoa);
	}
	
	public Pessoa buscarPorEmail(String email) {
		return DAOFactory.getPessoaDAO().buscaPorEmail(email);
	}
	
	public Pessoa loginParaJson(String email, String senha) {
		return DAOFactory.getPessoaDAO().loginParaJson(email, senha);
	}
	
}
