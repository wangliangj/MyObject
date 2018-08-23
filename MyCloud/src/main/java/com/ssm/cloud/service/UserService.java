package com.ssm.cloud.service;

import com.ssm.cloud.pojo.User;

public interface UserService {

    void addUser(User user);

    User getUserByUsername(String username);

    int getCountUser(String username);

    User doLogin(String username, String password);

}
