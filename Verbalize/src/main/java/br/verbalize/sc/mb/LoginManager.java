package br.verbalize.sc.mb;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.verbalize.sc.model.Pessoa;
import br.verbalize.sc.rn.PessoaRN;

@ManagedBean
@SessionScoped
public class LoginManager {
	
	
	private Pessoa pessoa;
	
	public void login() throws ServletException, IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/login");
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		
		SecurityContext contextSecurity = SecurityContextHolder.getContext();
		Authentication authentication = contextSecurity.getAuthentication();
		if (authentication != null && authentication.getPrincipal() != null) {
			String email = ((User) authentication.getPrincipal()).getUsername();
			PessoaRN pessoaRN = new PessoaRN();
			pessoa = pessoaRN.buscarPorEmail(email);
		} else {
			pessoa = null;
		}
		
	}
	
	public void logout() throws ServletException, IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/logout");
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		pessoa = null;
	}
	
	public String goLogin() {
		return "/login";
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
