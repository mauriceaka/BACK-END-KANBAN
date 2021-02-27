package fr.istic.taa.jaxrs.dao.specific;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Tag;

public class TagDao extends AbstractJpaDao<Long, Tag> {

    public TagDao(){
        setClazz(Tag.class);
    }
}
