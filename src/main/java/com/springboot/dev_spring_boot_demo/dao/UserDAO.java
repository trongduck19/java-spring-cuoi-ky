package com.springboot.dev_spring_boot_demo.dao;

import com.springboot.dev_spring_boot_demo.entity.User;
import java.util.List;

public interface UserDAO {
    // Lấy danh sách tất cả người dùng
    List<User> findAll();
    // Tìm người dùng theo ID
    User findById(int id);
    // Lưu hoặc cập nhật người dùng
    User save(User user);
    // Xóa người dùng theo ID
    void deleteById(int id);
}
    

