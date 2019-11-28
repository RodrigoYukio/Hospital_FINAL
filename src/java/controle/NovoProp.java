package controle;

import dao.DAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Proprietario;

@ManagedBean (name="novoProp") 
@ViewScoped
public class NovoProp implements Serializable {
    private Proprietario prop;
    private DAO<Proprietario> dao; 
    
    public NovoProp(){
        prop = new Proprietario();
        dao = new DAO(Proprietario.class);
    }
    
    public void salvar(){
        dao.inserir(prop);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage
          (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
          "Proprietario cadastrado", null));
    }
    

    public Proprietario getProp() {
        return prop;
    }

    public void setProp(Proprietario prop) {
        this.prop = prop;
    }

    public DAO<Proprietario> getDao() {
        return dao;
    }

    public void setDao(DAO<Proprietario> dao) {
        this.dao = dao;
    }
    
    
    
}