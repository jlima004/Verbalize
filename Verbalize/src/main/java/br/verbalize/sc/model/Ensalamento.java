package br.verbalize.sc.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ensalamento {
	
	@Id
	@GeneratedValue
	private long id;
	@Temporal(TemporalType.DATE)
	@Column
	private Date dia;
	@Temporal(TemporalType.TIME)
	@Column
	private Date inicio;
	@Temporal(TemporalType.TIME)
	@Column
	private Date fim;
	@ManyToOne
	private Turma turma;
	@ManyToOne
	private Ambiente ambiente;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
