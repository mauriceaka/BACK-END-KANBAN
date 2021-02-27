package fr.istic.taa.jaxrs.dao.specific;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.User;

public class UserDao  extends AbstractJpaDao <Long, User >{

    // préciser la classe avec setClazz

    public UserDao(){setClazz(User.class);}
}
