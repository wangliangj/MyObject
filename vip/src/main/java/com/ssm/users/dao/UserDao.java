package com.ssm.users.dao;

import com.ssm.users.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    User getUserByUsername(String username);

    String  getPasswordById(Integer id);

    void updateUser(User user);

    Integer getUserStatus(Integer id);

    Integer getCountByUserName(String username);

    List<User> getUserList(Map<String, Object> param);





}
