package br.verbalize.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.verbalize.sc.model.Turma;
import br.verbalize.sc.rn.TurmaRN;

@FacesConverter(forClass = Turma.class)
public class TurmaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String valor) {
		Long id = Long.parseLong(valor);

		TurmaRN rn = new TurmaRN();

		return rn.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object valor) {
		Turma turma = (Turma) valor;
		return turma.getId().toString();
	}

}
