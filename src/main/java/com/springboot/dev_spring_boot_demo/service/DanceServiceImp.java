package com.springboot.dev_spring_boot_demo.service;

import com.springboot.dev_spring_boot_demo.dao.DanceDAO;
import com.springboot.dev_spring_boot_demo.entity.Dance;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanceServiceImp implements DanceService {
    private DanceDAO danceDAO;

    @Autowired
    public DanceServiceImp(DanceDAO danceDAO) {
        this.danceDAO = danceDAO;
    }

    @Override
    public List<Dance> findAll() {
        return danceDAO.findAll();
    }

    @Override
    public Dance findById(int id) {
        return danceDAO.findById(id);
    }

    @Override
    public Dance save(Dance dance) {
        return danceDAO.save(dance);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        danceDAO.deleteById(id);
    }
}