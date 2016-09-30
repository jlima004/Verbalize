package br.verbalize.sc.model;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;


//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;


@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=100)
	private String nmPessoa;

	@Column(unique=true, length=100)
	private String email;
	
	@Column(nullable=false, length=14)
	private String nuCpf;
	
	@Column(length=13)
	private String telefone;
	
	/*@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dtNascimento;*/

	@Column(nullable=false, length=14)
	private String senha;
	
	//@Enumerated(EnumType.STRING)
	private String perfil;
	
	/*@Column(nullable=false, length=1)
	private int tpPermissao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dtCadastro;*/
	
	public Pessoa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNuCpf() {
		return nuCpf;
	}

	public void setNuCpf(String nuCpf) {
		this.nuCpf = nuCpf;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/*public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}*/

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	public Perfil getPerfil() {
//		return perfil;
//	}
//
//	public void setPerfil(Perfil perfil) {
//		this.perfil = perfil;
//	}

	

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nmPessoa == null) ? 0 : nmPessoa.hashCode());
		result = prime * result + ((nuCpf == null) ? 0 : nuCpf.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nmPessoa == null) {
			if (other.nmPessoa != null)
				return false;
		} else if (!nmPessoa.equals(other.nmPessoa))
			return false;
		if (nuCpf == null) {
			if (other.nuCpf != null)
				return false;
		} else if (!nuCpf.equals(other.nuCpf))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	


}
