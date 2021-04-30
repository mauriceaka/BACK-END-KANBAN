package fr.istic.taa.jaxrs.dao.specific;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Section;

public class SectiondDao extends AbstractJpaDao<Long, Section> {

    public SectiondDao(){
        setClazz(Section.class);
    }

}
