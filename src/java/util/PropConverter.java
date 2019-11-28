


package util;


import dao.DAO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Proprietario;

@FacesConverter(value = "propConverter")
public class PropConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String nome) {
        Proprietario temp = null;
        DAO<Proprietario> dao = new DAO(Proprietario.class);
        try {
            temp = dao.buscarPorNome(nome);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione um dono"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Proprietario){
            Proprietario c = (Proprietario)obj;
            return c.getNome();
        }
        return "";
    }
    
}


