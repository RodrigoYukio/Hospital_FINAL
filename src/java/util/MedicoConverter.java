
package util;


import dao.DAO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Medico;

@FacesConverter(value = "medicoConverter")
public class MedicoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String nome) {
        Medico temp = null;
        DAO<Medico> dao = new DAO(Medico.class);
        try {
            temp = dao.buscarPorNome(nome);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione um Medico"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Medico){
            Medico c = (Medico)obj;
            return c.getNome();
        }
        return "";
    }
    
}
