package com.ssm.cloud.service.impl;

import com.ssm.cloud.dao.UserDao;
import com.ssm.cloud.pojo.User;
import com.ssm.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public int getCountUser(String username) {
        int countUser = userDao.getCountUser(username);
        return countUser;
    }

    @Override
    public User doLogin(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user==null||!user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }
}
