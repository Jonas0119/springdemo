package com.jonas.springdemo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;
    
    @Column(length = 100)
    private String password;
    
    @Column(nullable = false)
    private Boolean active = true;

    public User() {
    }

    public User(Long id, String username, String email, LocalDate registrationDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    // 添加新的构造函数，包含所有字段
    public User(Long id, String username, String email, LocalDate registrationDate, String password, Boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}