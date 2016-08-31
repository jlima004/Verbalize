package br.verbalize.sc.dao;

public class DAOFactory {
	
	private static TurmaDAO turmaDAO;
	private static ArquivoDAO arquivoDAO;
	private static PessoaDAO pessoaDAO;
	private static RespostaDAO respostaDAO;
	
	public static TurmaDAO getTurmaDAO() {
		if (turmaDAO == null) {
			turmaDAO = new TurmaDAO();
		}
		return turmaDAO;
	}
	
	public static PessoaDAO getPessoaDAO() {
		if (pessoaDAO == null) {
			pessoaDAO = new PessoaDAO();
		}
		return pessoaDAO;
	}
	
	public static ArquivoDAO getArquivoDAO() {
		if (arquivoDAO == null) {
			arquivoDAO = new ArquivoDAO();
		}
		return arquivoDAO;
	}
	
	public static RespostaDAO getRespostaDAO() {
		if (respostaDAO == null) {
			respostaDAO = new RespostaDAO();
		}
		return respostaDAO;
	}
	
	
}