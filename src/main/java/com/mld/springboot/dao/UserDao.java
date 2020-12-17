package com.mld.springboot.dao;

import com.mld.springboot.pojo.User;

import java.util.List;

public interface UserDao {
    int addUser(User user);

    List<User> queryUsers();
}
