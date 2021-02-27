package fr.istic.taa.jaxrs.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement(name = "Tag")
public class Tag implements Serializable {
    private long id;
    private String libelle;
    private List<Fiche> fiche;

    public Tag(){}
    public Tag(String libelle){
        this.libelle=libelle;
    }


    public Tag(String libelle, List<Fiche> fiche){
        this.libelle=libelle;
        this.fiche=fiche;
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

    @XmlElement(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @ManyToMany
    @XmlElementWrapper(name = "fiches")
    @XmlElement(name = "fiche")
    public List<Fiche> getFiche() {
        return fiche;
    }

    public void setFiche(List<Fiche> fiche) {
        this.fiche = fiche;
    }
}
