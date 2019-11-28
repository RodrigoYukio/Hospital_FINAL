
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;
import modelo.Proprietario;


@ManagedBean (name="novoAni") 
@ViewScoped
public class NovoAni implements Serializable {
    private Animal ani;
    private DAO<Animal> dao; 
    private List<Proprietario> props;
    private DAO<Proprietario> daoProp;
    
    public NovoAni(){
        ani = new Animal();
        dao = new DAO(Animal.class);
        daoProp = new DAO(Proprietario.class);
        props = daoProp.listarTodos();
        
    }
    
    public void salvar(){
        dao.inserir(ani);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage
          (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
          "Animal Cadastrado", null));
    }

    public Animal getAni() {
        return ani;
    }

    public void setAni(Animal ani) {
        this.ani = ani;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }

    public List<Proprietario> getProps() {
        return props;
    }

    public void setProps(List<Proprietario> props) {
        this.props = props;
    }

    public DAO<Proprietario> getDaoProp() {
        return daoProp;
    }

    public void setDaoProp(DAO<Proprietario> daoProp) {
        this.daoProp = daoProp;
    }
                  
    }
