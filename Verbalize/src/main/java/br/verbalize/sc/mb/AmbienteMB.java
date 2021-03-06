package br.verbalize.sc.mb;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.verbalize.sc.model.Ambiente;
import br.verbalize.sc.rn.AmbienteRN;

@ManagedBean
@SessionScoped
public class AmbienteMB {

	private Ambiente ambiente;
	private AmbienteRN ambienteRN;
	private List<Ambiente> listaAmbientes;

	@PostConstruct
	public void init() {
		ambiente = new Ambiente();
		ambienteRN = new AmbienteRN();
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public AmbienteRN getAmbienteRN() {
		return ambienteRN;
	}

	public void setAmbienteRN(AmbienteRN ambienteRN) {
		this.ambienteRN = ambienteRN;
	}

	public List<Ambiente> getListaAmbientes() {
		if (listaAmbientes == null) {
			listaAmbientes = ambienteRN.listar();
		}
		return listaAmbientes;
	}

	public void setListaAmbientes(List<Ambiente> listaAmbientes) {
		this.listaAmbientes = listaAmbientes;
	}

	public String salvar() {
		try {
			ambienteRN.salvar(ambiente);
			listaAmbientes = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ambiente cadastrado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "/admin/listarAmbientes";
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
		return "";
	}
	
	public String listar() {
		return "/admin/listarAmbientes";
	}
	
	public String editar() {
		return "/admin/cadastroAmbiente";
	}
	
	public String excluir() {
		ambienteRN.excluir(ambiente);
		listaAmbientes.remove(ambiente);
		ambiente = new Ambiente();
		return "";
	}
	
	public String novo() {
		ambiente = new Ambiente();
		return "/admin/cadastroAmbiente";
	}

}
