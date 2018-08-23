package com.ssm.users.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.users.dao.UserDao;
import com.ssm.users.pojo.User;
import com.ssm.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    @Override
    public String getPasswordById(Integer id) {
        return userDao.getPasswordById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User doLogin(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user==null || !password.equals(user.getPassword()) ) {
            return null;
        }
        return user;
    }

    @Override
    public Integer getUserStatus(Integer id) {
        return userDao.getUserStatus(id);
    }

    @Override
    public Integer getCountByUserName(String username) {
        return userDao.getCountByUserName(username);
    }

    @Override
    public PageInfo<User> getUserList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(userDao.getUserList(param));
    }
}
