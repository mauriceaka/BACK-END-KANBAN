package fr.istic.taa.jaxrs.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement(name = "Section")
public class Section implements Serializable {
    private long id;
    private String nomsection;
    private List<Fiche> fiches;

    public Section() {
    }

    public Section(String nomsection) {
        this.nomsection = nomsection;
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


    @XmlElement(name = "nomsection")
    public String getNomsection() {
        return nomsection;
    }

    public void setNomsection(String nomsection) {
        this.nomsection = nomsection;
    }

    //    @XmlElementWrapper(name = "fiches")
//    @XmlElement(name = "fiche")
    @XmlTransient
    @OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }
}
