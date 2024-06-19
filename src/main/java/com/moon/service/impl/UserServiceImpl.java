package com.moon.service.impl;

import com.moon.dao.UserDao;
import com.moon.pojo.User;
import com.moon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moonjay
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() { return userDao.findAll(); }

    @Override
    public User findUser(String name,String pwd) { return userDao.findUserByNameAndPwd(name,pwd); }
}
