package fr.istic.taa.jaxrs.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement(name = "User")
public class User implements Serializable {
    private long id;
    private String nom;
    private String profession;
    private List<Fiche> fiche=new ArrayList<Fiche>();
    private String email;

    public User(){}

    public User( String nom, String profession, List<Fiche> fiche ,String email){
        this.nom = nom;
        this.profession = profession;
        this.fiche = fiche;
        this.email = email;
    }
    public User( String nom, String profession){
        this.nom = nom;
        this.profession = profession;
    }

    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "Nom")
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement(name = "Profession")
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @XmlTransient
    public List<Fiche> getFiche() {
        return fiche;
    }
    public void setFiche(List<Fiche> fiche) {
        this.fiche = fiche;
    }

    @XmlElement(name = "Email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
