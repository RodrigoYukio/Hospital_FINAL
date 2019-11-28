package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Consulta;
import modelo.Medico;
import modelo.Animal;

@ManagedBean
@ViewScoped
public class ConsultaControle implements Serializable {

    private Consulta consulta;
    private DAO<Consulta> dao;
    private List<Consulta> lista;
    private boolean popupNovo;
    private boolean popupAltera;
    private List<Medico> medicos;
    private DAO<Medico> daoMedico;
    private List<Animal> animais;
    private DAO<Animal> daoAnimal;
    
    public ConsultaControle() {
        consulta = new Consulta();
        dao = new DAO(Consulta.class);
        daoMedico = new DAO (Medico.class);
        medicos = daoMedico.listarTodos();        
        daoAnimal = new DAO (Animal.class);
        animais = daoAnimal.listarTodos();
        lista = dao.listarTodos();
        popupNovo = false; // fica oculto
        popupAltera = false; // fica oculto
    }

    public void abrePopupNovo() {
        consulta = new Consulta();
        this.popupNovo = true;
    }

    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }

//    public void converter() {
//        consulta.setNome(consulta.getNome().toUpperCase());
//    }
    
    public void alterar(){
        abrePopupAltera();
    }

    public void inserir() {
        // só pode inserir se não existir o login
//        converter();
//        boolean jaExiste = true;
//        try {
//            Consulta temp = new DAOADm().buscaPorLogin(consulta.getNome());
//        } catch (ExcecaoObjetoNaoEncontrado e) {
//            jaExiste = false;
//        }
//        if (!jaExiste) {
            dao.inserir(consulta);
            lista = dao.listarTodos();
            consulta = new Consulta();  // apenas para limpar os campos
            fecharPopupNovo();
//        } else {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                    "Já existe este LOGIN", null));
//        }

    }

    public void alterarConsulta() {
        dao.alterar(consulta);
        lista = dao.listarTodos(); // atualiza a lista
        consulta = new Consulta(); 
        fecharPopupAltera();
    }
    public void excluir(Consulta consulta){
        dao.excluir(consulta.getId());
        lista.remove(consulta);
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

    public List<Consulta> getLista() {
        return lista;
    }

    public void setLista(List<Consulta> lista) {
        this.lista = lista;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
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