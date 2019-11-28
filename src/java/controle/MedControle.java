package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Medico;

@ManagedBean
@ViewScoped
public class MedControle implements Serializable {

    private Medico med;
    private DAO<Medico> dao;
    private List<Medico> lista;
    private boolean popupNovo;
    private boolean popupAltera;

    public MedControle() {
        med = new Medico();
        dao = new DAO(Medico.class);
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
       
    public void alterar(){
        abrePopupAltera();
    }
    
    public void inserirMedico(){
        dao.inserir(med);
        lista = dao.listarTodos();
        med = new Medico();
        fecharPopupNovo();
    }
    
    
    public void alterarMedico() {
        dao.alterar(med);
        lista = dao.listarTodos(); // atualiza a lista
        med = new Medico(); 
        fecharPopupAltera();
    }
    
    public void excluir(Medico med){
        dao.excluir(med.getId());
        lista.remove(med);
    }
       
    public Medico getMed() {
        return med;
    }

    public void setMed(Medico med) {
        this.med = med;
    }

    public DAO<Medico> getDao() {
        return dao;
    }

    public void setDao(DAO<Medico> dao) {
        this.dao = dao;
    }

    public List<Medico> getLista() {
        return lista;
    }

    public void setLista(List<Medico> lista) {
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