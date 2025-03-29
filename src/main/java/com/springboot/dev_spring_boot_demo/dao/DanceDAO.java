package com.springboot.dev_spring_boot_demo.dao;

import com.springboot.dev_spring_boot_demo.entity.Dance;

import java.util.List;

public interface DanceDAO {
    List<Dance> findAll();
    Dance findById(int id);
    Dance save(Dance dance);
    void deleteById(int id);
}
