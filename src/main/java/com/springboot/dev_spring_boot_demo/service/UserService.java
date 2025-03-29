package com.springboot.dev_spring_boot_demo.service;

import com.springboot.dev_spring_boot_demo.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    User save(User user);
    void deleteById(int id);
}
