package com.ssm.question.service.impl;

import com.ssm.question.dao.UserDao;
import com.ssm.question.pojo.User;
import com.ssm.question.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) throws Exception {
        if (getUserCountByName(user.getUsername())>0) {
            throw new Exception("用户名已经存在");
        }
        userDao.addUser(user);
    }

    @Override
    public int getUserCountByName(String username) {
        return userDao.getUserCountByName(username);
    }

    @Override
    public User doLogin(String username, String password) throws Exception {
        User user = userDao.getUserByName(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("用户名或密码错误");
        }
        return user;
    }
}
