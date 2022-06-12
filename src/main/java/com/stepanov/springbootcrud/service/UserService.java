package com.stepanov.springbootcrud.service;

import com.stepanov.springbootcrud.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void save(User employee);

    void deleteById(int id);
}
