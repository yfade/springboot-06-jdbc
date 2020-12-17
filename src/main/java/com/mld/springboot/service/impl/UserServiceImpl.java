package com.mld.springboot.service.impl;

import com.mld.springboot.dao.UserDao;
import com.mld.springboot.pojo.User;
import com.mld.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> queryUsers() {
        return userDao.queryUsers();
    }
}
