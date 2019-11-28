package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Consulta;
import modelo.Proprietario;

@ManagedBean
@ViewScoped
public class AniControle implements Serializable {

    private Animal animal;
    private DAO<Animal> dao;
    private List<Animal> lista;
    private boolean popupNovoAnimal;
    private boolean popupAltera;
    private boolean popupConsulta;
    private List<Proprietario> proprietarios;
    private DAO<Proprietario> daoProprietario;
    

    
    public AniControle() {
        animal = new Animal();
        dao = new DAO(Animal.class);
        daoProprietario = new DAO (Proprietario.class);
        proprietarios = daoProprietario.listarTodos();
        lista = dao.listarTodos();    
        popupNovoAnimal = false;    // fica oculto
        popupAltera = false;  // fica oculto
        popupConsulta = false; // fica oculto
    }

    public void abrePopupNovoAnimal() {
        animal = new Animal();
        this.popupNovoAnimal = true;
    }

    public void fecharPopupNovoAnimal() {
        this.popupNovoAnimal = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }
    public void abrePopupConsulta(){
        this.popupConsulta = true;
        animal.getConsulta();
    }
    public void fecharPopupConsulta(){
        this.popupConsulta = false;
    }

    
    
//    public void converter() {
//        animal.setNome(animal.getNome().toUpperCase());
//    }
    
    public void alterar(){
        abrePopupAltera();
    }

    public void mostrarConsultas(){
        abrePopupConsulta();
    }
    public void inserir() {
        // só pode inserir se não existir o login
//        converter();
//        boolean jaExiste = true;
//        try {
//            Animal temp = new DAOADm().buscaPorLogin(animal.getNome());
//        } catch (ExcecaoObjetoNaoEncontrado e) {
//            jaExiste = false;
//        }
//        if (!jaExiste) {
            dao.inserir(animal);
            lista = dao.listarTodos();
            animal = new Animal();  // apenas para limpar os campos
            fecharPopupNovoAnimal();
//        } else {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                    "Já existe este LOGIN", null));
//        }

    }

    
    public void alterarAnimal() {
        dao.alterar(animal);
        lista = dao.listarTodos(); // atualiza a lista
        animal = new Animal(); 
        fecharPopupAltera();
    }
    
    public void excluir(Animal animal){
        dao.excluir(animal.getId());
        lista.remove(animal);
    }

    public List<Proprietario> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<Proprietario> proprietarios) {
        this.proprietarios = proprietarios;
    }

    public DAO<Proprietario> getDaoProprietario() {
        return daoProprietario;
    }

    public void setDaoProprietario(DAO<Proprietario> daoProprietario) {
        this.daoProprietario = daoProprietario;
    }
    
    
    
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }

    public List<Animal> getLista() {
        return lista;
    }

    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }

    public boolean isPopupNovoAnimal() {
        return popupNovoAnimal;
    }

    public void setPopupNovoAnimal(boolean popupNovo) {
        this.popupNovoAnimal = popupNovo;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }

    public boolean isPopupConsulta() {
        return popupConsulta;
    }

    public void setPopupConsulta(boolean popupConsulta) {
        this.popupConsulta = popupConsulta;
    }
}