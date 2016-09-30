package br.verbalize.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.verbalize.sc.model.Pessoa;
import br.verbalize.sc.rn.PessoaRN;

@ManagedBean
@SessionScoped
public class PessoaMb {
	private Pessoa pessoa;
	private PessoaRN pessoaRN;
	private Long editarId;
	private List<Pessoa> listaPessoas;
	private List<Pessoa> listaProfessores;

	@PostConstruct
	public void depoisDeConstruir() {
		pessoa = new Pessoa();
		pessoaRN = new PessoaRN();
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
	
	public void carregarPessoa(ComponentSystemEvent event) {
		if(editarId == null) {
			return ;
		}
		pessoa = pessoaRN.buscarPorId(editarId);
	}
	
	public String excluir() {
		//Long idExcluir = Long.parseLong(id);
		pessoaRN.excluir(pessoa);
		listaPessoas = null;
		return "";
	}
	
	public String salvar() {
		try {
			pessoaRN.salvar(pessoa);
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
	
}
