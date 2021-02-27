package fr.istic.taa.jaxrs.dao.specific;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.Section;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SectiondDao extends AbstractJpaDao<Long, Section> {

    public SectiondDao(){
        setClazz(Section.class);
    }

}
