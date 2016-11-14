package br.verbalize.sc.json;

import java.util.Date;

import br.verbalize.sc.model.Ambiente;
import br.verbalize.sc.model.Turma;

public class EnsalamentoJson {
	
	private Date dia;
	private Date inicio;
	private Date fim;
	private Turma turma;
	private Ambiente ambiente;
	
	
	
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Ambiente getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	
	
	
	
	

}
