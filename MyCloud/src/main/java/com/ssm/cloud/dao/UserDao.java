package com.ssm.cloud.dao;

import com.ssm.cloud.pojo.User;

public interface UserDao {

    void addUser(User user);

    int getCountUser(String username);

    User getUserByUsername(String username);

}
