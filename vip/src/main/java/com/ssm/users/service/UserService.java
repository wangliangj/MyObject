package com.ssm.users.service;

import com.github.pagehelper.PageInfo;
import com.ssm.users.pojo.User;

import java.util.Map;

public interface UserService {


    User getUserByUsername(String username);

    String  getPasswordById(Integer id);

    void updateUser(User user);

    User doLogin(String username, String password);

    Integer getUserStatus(Integer id);

    Integer getCountByUserName(String username);

    PageInfo<User> getUserList(Map<String, Object> param, int pageNum, int pageSize);


}
