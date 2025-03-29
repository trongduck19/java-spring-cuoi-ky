package com.springboot.dev_spring_boot_demo.dao;

import com.springboot.dev_spring_boot_demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return em.merge(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }
}

