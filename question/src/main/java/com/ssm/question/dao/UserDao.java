package com.ssm.question.dao;

import com.ssm.question.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    void addUser(User user);

    //验证用户是否存在
    int getUserCountByName(@Param("username") String username);

    User getUserByName(@Param("username") String username);


}
