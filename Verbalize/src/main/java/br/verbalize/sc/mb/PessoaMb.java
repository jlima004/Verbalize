package br.verbalize.sc.mb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
	
	public void gerarPdf(){
		//caso nao carregue verificar anotação da pagina
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		
		try {
			
			Document document = new Document();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			
			document.open();
			
			document.add(new Paragraph("Escrevendo em um pdf!"));
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			PessoaRN pessoaRN = new PessoaRN();
			List<Pessoa> pessoas = pessoaRN.listar();
			
			PdfPTable table = new PdfPTable(2);
			
			table.addCell(createHeader("Nome"));
			table.addCell(createHeader("CPF"));
		
			
			table.addCell("Nome");
			table.addCell("CPF");
			
			BaseColor color = BaseColor.GRAY;
			for (Pessoa u : pessoas) {
				table.addCell(createBody(u.getNmPessoa(), color));
				table.addCell(createBody(u.getNuCpf(), color));
				if (color.equals(BaseColor.GRAY)) {
					color = BaseColor.LIGHT_GRAY;
				} else {
					color = BaseColor.GRAY;
				}
				
				
			}
			
			document.close();
			
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidade, post-check=0");
			
			response.setHeader("Pragma", "public");
			
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline;filename=teste.pdf");
			//possivel mudar o nome do inline para o nome de quem recebera o arquivo
			
			response.setContentLength(baos.size());
			
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();
			
			
		} catch (Exception e){
			System.out.println("Erro ao gerar o pdf!");
			e.printStackTrace();
		}
		context.responseComplete();
	}
	
	/*
	 * METODOS PARA SEREM COLOCADOS NA CLASE UTIL
	 */
private PdfPCell createHeader(String titulo) {
		Phrase phrase = new Phrase(titulo);
		phrase.setFont(new Font(FontFamily.HELVETICA, 16, Font.BOLD));
		PdfPCell cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.BOTTOM);
		cell.setBorderWidthBottom(3);
		return cell;
	}
	
	private PdfPCell createBody(String value, BaseColor color) {
		Phrase phrase = new Phrase(value);
		phrase.setFont(new Font(FontFamily.HELVETICA, 14, Font.NORMAL));
		PdfPCell cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setBackgroundColor(color);
		return cell;
	}

	
	
	
	public String salvar() {
		try {
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
	
	
	
}
