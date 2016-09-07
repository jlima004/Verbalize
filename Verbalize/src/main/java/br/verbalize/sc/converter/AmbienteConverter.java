package br.verbalize.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.verbalize.sc.model.Ambiente;
import br.verbalize.sc.rn.AmbienteRN;

@FacesConverter(forClass = Ambiente.class)
public class AmbienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context,
			UIComponent component, String value) {
			AmbienteRN ambienteRN = new AmbienteRN();
			long id = Long.parseLong(value);
			return ambienteRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext context,
			UIComponent component, Object value) {
		Ambiente ambiente = (Ambiente) value;
		return String.valueOf(ambiente.getId());
	}

}
