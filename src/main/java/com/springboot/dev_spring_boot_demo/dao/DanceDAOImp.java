package com.springboot.dev_spring_boot_demo.dao;

import com.springboot.dev_spring_boot_demo.entity.Dance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DanceDAOImp implements DanceDAO {
    private EntityManager em;

    @Autowired
    public DanceDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Dance> findAll() {
        TypedQuery<Dance> query = em.createQuery("from Dance", Dance.class);
        return query.getResultList();
    }

    @Override
    public Dance findById(int id) {
        return em.find(Dance.class, id);
    }

    @Override
    @Transactional
    public Dance save(Dance dance) {
        return em.merge(dance);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Dance dance = em.find(Dance.class, id);
        if (dance != null) {
            em.remove(dance);
        }
    }
}
