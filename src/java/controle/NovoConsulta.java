
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;
import modelo.Consulta;
import modelo.Medico;


@ManagedBean (name="novoConsulta") 
@ViewScoped
public class NovoConsulta implements Serializable {
    private Consulta consulta;
    private DAO<Consulta> dao; 
    private List<Medico> medicos;
    private DAO<Medico> daoMedico;
    private List<Animal> animais;
    private DAO<Animal> daoAnimal;
    
    public NovoConsulta(){
        consulta = new Consulta();
        dao = new DAO(Consulta.class);
        daoMedico = new DAO(Medico.class);
        medicos = daoMedico.listarTodos();
        daoAnimal = new DAO(Animal.class);
        animais = daoAnimal.listarTodos();
        
    }
    
    public void salvar(){
        dao.inserir(consulta);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage
          (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
          "Consulta Cadastrado", null));
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public DAO<Consulta> getDao() {
        return dao;
    }

    public void setDao(DAO<Consulta> dao) {
        this.dao = dao;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public DAO<Medico> getDaoMedico() {
        return daoMedico;
    }

    public void setDaoMedico(DAO<Medico> daoMedico) {
        this.daoMedico = daoMedico;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public DAO<Animal> getDaoAnimal() {
        return daoAnimal;
    }

    public void setDaoAnimal(DAO<Animal> daoAnimal) {
        this.daoAnimal = daoAnimal;
    }
                  
    }
