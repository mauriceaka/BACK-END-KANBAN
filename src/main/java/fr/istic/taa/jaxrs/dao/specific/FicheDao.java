package fr.istic.taa.jaxrs.dao.specific;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Section;

public class FicheDao extends AbstractJpaDao<Long, Fiche> {

    public FicheDao(){
        setClazz(Fiche.class);
    }
}
