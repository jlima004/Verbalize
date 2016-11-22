package br.verbalize.sc.mb;


import java.io.IOException;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.verbalize.sc.commons.Utils;
import br.verbalize.sc.json.LoginJson;
import br.verbalize.sc.model.Agenda;
import br.verbalize.sc.model.Pessoa;
import br.verbalize.sc.rn.EnsalamentoRN;
import br.verbalize.sc.rn.PessoaRN;

@ManagedBean
@SessionScoped
public class PessoaMb {
	private Pessoa pessoa;
	private PessoaRN pessoaRN;
	private EnsalamentoRN ensalamentoRN;
	private Long editarId;
	private List<Pessoa> listaPessoas;
	private List<Pessoa> listaProfessores;

	@PostConstruct
	public void depoisDeConstruir() {
		pessoa = new Pessoa();
		pessoaRN = new PessoaRN();
		ensalamentoRN = new EnsalamentoRN();
	}
	

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Long getEditarId() {
		return editarId;
	}
	
	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
	
	public List<Pessoa> getListaPessoas() {
		if(listaPessoas == null) {
			listaPessoas = pessoaRN.listar();
		}
		return listaPessoas;
	}
	
	public List<Pessoa> getListaProfessores() {
		if(listaProfessores == null) {
			listaProfessores = pessoaRN.ListarProfessores();
		}
		return listaProfessores;
	}
	
	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
	
	public EnsalamentoRN getEnsalamentoRN() {
		return ensalamentoRN;
	}


	public void setEnsalamentoRN(EnsalamentoRN ensalamentoRN) {
		this.ensalamentoRN = ensalamentoRN;
	}


	public List<Agenda> retornaAgenda(Pessoa pessoa) {
		long id = pessoa.getId();
		return ensalamentoRN.retornaAgenda(id);
	}


	public void carregarPessoa(ComponentSystemEvent event) {
		if(editarId == null) {
			return ;
		}
		pessoa = pessoaRN.buscarPorId(editarId);
	}
	
	public String excluir() {
		
		pessoaRN.excluir(pessoa);
		listaPessoas.remove(pessoa);
		pessoa = new Pessoa();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário removido com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
		
	}
	
	
	
	
	
	public String editar() {
		return "/admin/pessoaForm.xhtml";
	}
	
	
	
	
	public String salvar() {
		try {
			String hash = Utils.senhaToSha256(pessoa.getSenha());
			pessoa.setSenha(hash);
			pessoaRN.salvar(pessoa);
			listaPessoas = null;
			return "/admin/pessoaList";
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e
							.getMessage()));
		}
		return "index.xhtml";
		
		
	}
	
	public void renderLoginJson() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		
		String email = externalContext.getRequestParameterMap().get("email");
		String senha = externalContext.getRequestParameterMap().get("senha");
		String key = externalContext.getRequestParameterMap().get("key");
		
		String json = "";
		if (key != null && key.equals(Utils.KEY)) {
			Pessoa p = pessoaRN.loginParaJson(email, senha);
			if (p != null) {
				LoginJson lj = new LoginJson();
				lj.setNmPessoa(p.getNmPessoa());
				lj.setSucesso(true);
				lj.setPerfil("ROLE_USER");
				json = Utils.getGson().toJson(lj);
			}
		}
		
		externalContext.setResponseContentType("application/json");
		externalContext.setResponseCharacterEncoding("UTF-8");
		externalContext.getResponseOutputWriter().write(json);
		context.responseComplete();
		
		
	}
	
	
	
}
