package br.verbalize.sc.mb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.verbalize.sc.model.Ensalamento;
import br.verbalize.sc.model.Pessoa;
import br.verbalize.sc.rn.EnsalamentoRN;
import br.verbalize.sc.rn.PessoaRN;





@ManagedBean
@RequestScoped
public class PdfMB {

	public void gerarPdf() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) 
				context.getExternalContext().getResponse();
		
		try {
			
			Document document = new Document();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			
			document.open();
			
			document.add(new Paragraph("Agenda"));
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			EnsalamentoRN ensalamentoRN = new EnsalamentoRN();
			List<Ensalamento> ensalamentos = ensalamentoRN.listar();
			
			PdfPTable table = new PdfPTable(5);
			
			table.addCell(createHeader("Dia"));
			table.addCell(createHeader("Inicio"));
			table.addCell(createHeader("Fim"));
			table.addCell(createHeader("Turma"));
			table.addCell(createHeader("Ambiente"));
			
			BaseColor color = BaseColor.GRAY;
			for (Ensalamento u : ensalamentos) {
				table.addCell(createBody(u.getDia().toString(), color));
				table.addCell(createBody(u.getInicio().toString(), color));
				table.addCell(createBody(u.getFim().toString(), color));
				table.addCell(createBody(u.getTurma().getNmTurma(), color));
				table.addCell(createBody(u.getAmbiente().getNome(), color));
				if (color.equals(BaseColor.GRAY)) {
					color = BaseColor.LIGHT_GRAY;
				} else {
					color = BaseColor.GRAY;
				}			}
			document.add(table);
			
			document.close();
			
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			
			response.setHeader("Pragma", "public");
			
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline;filename=teste.pdf");
			
			response.setContentLength(baos.size());
			
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao gerar o pdf!");
			e.printStackTrace();
		}
		context.responseComplete();
	}
	
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
	
}