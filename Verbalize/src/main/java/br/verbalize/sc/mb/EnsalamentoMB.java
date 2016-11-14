package br.verbalize.sc.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.verbalize.sc.commons.Utils;
import br.verbalize.sc.model.Ensalamento;
import br.verbalize.sc.rn.EnsalamentoRN;

@ManagedBean
@SessionScoped
public class EnsalamentoMB {

	private Ensalamento ensalamento;
	private EnsalamentoRN ensalamentoRN;
	private List<Ensalamento> listaEnsalamentos;

	@PostConstruct
	public void init() {
		ensalamento = new Ensalamento();
		ensalamentoRN = new EnsalamentoRN();
	}

	public Ensalamento getEnsalamento() {
		return ensalamento;
	}

	public void setEnsalamento(Ensalamento ensalamento) {
		this.ensalamento = ensalamento;
	}

	public EnsalamentoRN getEnsalamentoRN() {
		return ensalamentoRN;
	}

	public void setEnsalamentoRN(EnsalamentoRN ensalamentoRN) {
		this.ensalamentoRN = ensalamentoRN;
	}

	public List<Ensalamento> getListaEnsalamentos() {
		if (listaEnsalamentos == null) {
			listaEnsalamentos = ensalamentoRN.listar();
		}
		return listaEnsalamentos;
	}

	public void setListaEnsalamentos(List<Ensalamento> listaEnsalamentos) {
		this.listaEnsalamentos = listaEnsalamentos;
	}

	public String salvar() {
		try {
			ensalamentoRN.salvar(ensalamento);
			listaEnsalamentos = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ensalamento cadastrado com sucesso!",
					"");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "/admin/listarEnsalamentos";
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
		return "";
	}

	public String listar() {
		return "/admin/listarEnsalamentos";
	}

	public String editar() {
		return "/admin/cadastroEnsalamento";
	}

	public String excluir() {
		ensalamentoRN.excluir(ensalamento);
		listaEnsalamentos.remove(ensalamento);
		ensalamento = new Ensalamento();
		return "";
	}
	
	public void renderListaEnsalamentosJson() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		
		String key = externalContext.getRequestParameterMap().get("key");
		
		String json = "";
		if (key != null && key.equals(Utils.KEY)) {
			json = Utils.getGson().toJson(ensalamentoRN.listarEnsalamentoParaJson());
		}
		
		externalContext.setResponseContentType("application/json");
		externalContext.setResponseCharacterEncoding("UTF-8");
		externalContext.getResponseOutputWriter().write(json);
		context.responseComplete();
		
	}

}
