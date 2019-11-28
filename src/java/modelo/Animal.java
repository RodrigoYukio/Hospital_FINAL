
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Animal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    @Column(length = 30)
     private String nome;
    @Column(length = 30)
    private String especie;
    @Column(length = 30)    
    private String raça;

    @ManyToOne
    @JoinColumn (name = "prop")
    private Proprietario prop;

    @Column(length = 30)    
    private String idade;
         
    @OneToMany(mappedBy = "animal", orphanRemoval = true)
    //@ManyToOne
    //@JoinColumn (name = "animal")
    private List<Consulta> consulta;

    //private List<String> consultas;
    
    //public List<String> getConsultas() {
//    //   for (int i = 0; i < this.getConsulta().size(); i++) {
//            SimpleDateFormat s = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
//            consultas.add(s.format(consulta.get(i).getData())+consulta.get(i).getId() +consulta.get(i).getAnimal().nome + consulta.get(i).getMedico().getNome() + consulta.get(i).getAnotacao());
//        }
//       return consultas;
//    }

//    public void setConsultas(List<String> consultas) {
//        this.consultas = consultas;
//    }
//    
    
    public Animal(){
        id = 0;
        nome = "";
        especie= "";
        raça=""; 
        idade="";      
        prop = new Proprietario();
        consulta = new ArrayList<>();
        
    }

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.idade);
        hash = 97 * hash + Objects.hashCode(this.raça);
        hash = 97 * hash + Objects.hashCode(this.especie);
        hash = 97 * hash + Objects.hashCode(this.prop);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.raça, other.raça)) {
            return false;
        }
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;              
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nome=" + nome + ", raça=" + raça + ", idade=" + idade + ", especie=" + especie + ", prop=" + prop + "consulta=" + consulta + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

        public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }


    public Proprietario getProp() {
        return prop;
    }

    public void setProp(Proprietario prop) {
        this.prop = prop;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }


}

 
   