package fr.istic.taa.jaxrs.dao.specific;

import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.Section;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SectiondDao {

    private EntityManager manager;

    public SectiondDao(EntityManager manager) {
        this.manager = manager;
    }

    public Section findOne(Long id) {
        return manager.find(Section.class, id);
    }

    public List<Section> findAll() {
        return manager.createQuery("Select a From Section as a", Section.class).getResultList();
    }


    public void save(Section section) {
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        manager.persist(section);
        t.commit();
        manager.close();

    }
}
