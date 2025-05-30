package com.jonas.springdemo.repository;

import com.jonas.springdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 根据用户名查找用户
    User findByUsername(String username);
    
    // 根据邮箱查找用户
    User findByEmail(String email);
    
    // 查找所有活跃用户
    java.util.List<User> findByActiveTrue();
}