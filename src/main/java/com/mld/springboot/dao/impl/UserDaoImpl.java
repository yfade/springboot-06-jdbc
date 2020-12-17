package com.mld.springboot.dao.impl;

import com.mld.springboot.dao.UserDao;
import com.mld.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addUser(User user) {
        String sql = "insert into user(USER_NAME,AGE) values(?,?)";
        return jdbcTemplate.update(sql, user.getUserName(), user.getAge());
    }

    @Override
    public List<User> queryUsers() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getInt("ID"));
            user.setUserName(resultSet.getString("USER_NAME"));
            user.setAge(resultSet.getInt("AGE"));
            return user;
        });
        return list;
    }
}
