package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Proprietario;

@ManagedBean
@ViewScoped
public class PropControle implements Serializable {

    private Proprietario prop;
    private DAO<Proprietario> dao;
    private List<Proprietario> lista;
    private boolean popupNovo;
    private boolean popupAltera;

    public PropControle() {
        prop = new Proprietario();
        dao = new DAO(Proprietario.class);
        lista = dao.listarTodos();
        popupNovo = false;    // fica oculto
        popupAltera = false;  // fica oculto
    }

    public void abrePopupNovo() {
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

    //public void converter() {
    //    prop.setLogin(prop.getLogin().toUpperCase());
    //}
    
    public void alterar(){
        abrePopupAltera();
    }

    public void inserir() {
        // só pode inserir se não existir o login               
            dao.inserir(prop);
            lista = dao.listarTodos();
            prop = new Proprietario();  // apenas para limpar os campos
            fecharPopupNovo();
        

    }

    
    public void alterarProprietario() {
        dao.alterar(prop);
        lista = dao.listarTodos(); // atualiza a lista
        prop = new Proprietario(); 
        fecharPopupAltera();
    }
    
    public void excluir(Proprietario prop){
        dao.excluir(prop.getId());
        lista.remove(prop);
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

    public List<Proprietario> getLista() {
        return lista;
    }

    public void setLista(List<Proprietario> lista) {
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

}