package com.mld.springboot.service;

import com.mld.springboot.pojo.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    List<User> queryUsers();
}
