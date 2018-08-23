package com.ssm.bank.service;

import com.ssm.bank.pojo.User;

public interface UserService {

    User doLogin(String cardId, String password);

    User getUserByCardId(String cardId);

    void updateUser(User user);

    Integer getBalanceById(Integer id);

    String getPasswordById(Integer id);

    void doTrade(Integer userId, Float amount, String cardId) throws Exception;

}
