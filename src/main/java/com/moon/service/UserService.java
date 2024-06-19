package com.moon.service;

import com.moon.pojo.User;

import java.util.List;

/**
 * @author moonjay
 */
public interface UserService {
    void insertUser(User user);

    List<User> findAll();

    User findUser(String name,String pwd);
}
