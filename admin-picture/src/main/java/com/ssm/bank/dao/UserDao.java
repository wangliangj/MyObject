package com.ssm.bank.dao;

import com.ssm.bank.pojo.User;

public interface UserDao {
    User getUserByCardId(String cardId);

    void updateUser(User user);

    Integer getBalanceById(Integer id);

    String getPasswordById(Integer id);
}
