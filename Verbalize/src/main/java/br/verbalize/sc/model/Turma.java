package br.verbalize.sc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 100)
	private String nmTurma;
	private Date dataDeInicio;
	private Date dataDeConclusao;
	private Float mensalidade;
	@ManyToOne
	private Pessoa professor;
	@ManyToMany
	private List<Pessoa> alunosParaMatricular;
	@OneToMany
	private List<Arquivo> arquivosDaTurma;
	

	public Turma() {
		
	}

	public Turma(long id, String nmTurma, Date dataDeInicio, Date dataDeConclusao, Float mensalidade, Pessoa professor) {
		super();
		this.id = id;
		this.nmTurma = nmTurma;
		this.dataDeInicio = dataDeInicio;
		this.dataDeConclusao = dataDeConclusao;
		this.mensalidade = mensalidade;
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmTurma() {
		return nmTurma;
	}

	public void setNmTurma(String nmTurma) {
		this.nmTurma = nmTurma;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeConclusao() {
		return dataDeConclusao;
	}

	public void setDataDeConclusao(Date dataDeConclusao) {
		this.dataDeConclusao = dataDeConclusao;
	}

	public Float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Float mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Pessoa getProfessor() {
		return professor;
	}

	public void setProfessor(Pessoa professor) {
		this.professor = professor;
	}

	public List<Pessoa> getAlunosParaMatricular() {
		return alunosParaMatricular;
	}

	public void setAlunosParaMatricular(List<Pessoa> alunosParaMatricular) {
		this.alunosParaMatricular = alunosParaMatricular;
	}

	public List<Arquivo> getArquivosDaTurma() {
		return arquivosDaTurma;
	}

	public void setArquivosDaTurma(List<Arquivo> arquivosDaTurma) {
		this.arquivosDaTurma = arquivosDaTurma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDeConclusao == null) ? 0 : dataDeConclusao.hashCode());
		result = prime * result + ((dataDeInicio == null) ? 0 : dataDeInicio.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mensalidade == null) ? 0 : mensalidade.hashCode());
		result = prime * result + ((nmTurma == null) ? 0 : nmTurma.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (dataDeConclusao == null) {
			if (other.dataDeConclusao != null)
				return false;
		} else if (!dataDeConclusao.equals(other.dataDeConclusao))
			return false;
		if (dataDeInicio == null) {
			if (other.dataDeInicio != null)
				return false;
		} else if (!dataDeInicio.equals(other.dataDeInicio))
			return false;
		if (id != other.id)
			return false;
		if (mensalidade == null) {
			if (other.mensalidade != null)
				return false;
		} else if (!mensalidade.equals(other.mensalidade))
			return false;
		if (nmTurma == null) {
			if (other.nmTurma != null)
				return false;
		} else if (!nmTurma.equals(other.nmTurma))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}

	
	
	


	
	
	
	
	
	
}
