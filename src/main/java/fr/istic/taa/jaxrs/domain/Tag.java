package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@XmlRootElement(name = "Tag")
public class Tag implements Serializable {
    private long id;
    private String libelle;
    private Set<Fiche> fiche;

    public Tag() {
    }

    public Tag(String libelle) {
        this.libelle = libelle;
    }


    public Tag(String libelle, Set<Fiche> fiche) {
        this.libelle = libelle;
        this.fiche = fiche;
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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @XmlElementWrapper(name = "fiches")
//    @XmlElement(name = "fiche")
    @XmlTransient
    public Set<Fiche> getFiche() {
        return fiche;
    }

    public void setFiche(Set<Fiche> fiche) {
        this.fiche = fiche;
    }
}
