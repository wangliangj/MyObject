package com.ssm.bank.service.impl;

import com.ssm.bank.dao.TradeDao;
import com.ssm.bank.dao.UserDao;
import com.ssm.bank.pojo.Trade;
import com.ssm.bank.pojo.User;
import com.ssm.bank.service.UserService;
import com.ssm.bank.util.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TradeDao tradeDao;


    @Override
    public User doLogin(String cardId, String password) {
        User user = userDao.getUserByCardId(cardId);
        if (user ==null || !user.getPassword().equals(password)) {
            return  null;
        }
        return user;
    }

    @Override
    public User getUserByCardId(String cardId) {
        return userDao.getUserByCardId(cardId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public Integer getBalanceById(Integer id) {
        Integer balance = userDao.getBalanceById(id);
        return balance;
    }

    @Override
    public String getPasswordById(Integer id) {
        return userDao.getPasswordById(id);
    }

    @Override
    public void doTrade(Integer userId, Float amount, String cardId) throws Exception {
        Trade trade = new Trade();
        trade.setAmount((int) (amount * 100));
        trade.setType(Constans.TRADE_OUT);
        trade.setUserId(userId);
        Integer balance = userDao.getBalanceById(trade.getUserId());//当前用户余额
        if (balance < trade.getAmount()) {
            throw new Exception("余额不足");

        }
        User traderUser = userDao.getUserByCardId(cardId);
        trade.setTrader(traderUser.getId());
        Integer traderBalance = userDao.getBalanceById(trade.getTrader());//对方余额
        User self = new User();
        self.setId(trade.getUserId());
        self.setBalance(balance - trade.getAmount());
        userDao.updateUser(self);//减钱
        traderUser.setBalance(self.getBalance());
        tradeDao.addTrade(trade);
        traderUser.setId(trade.getTrader());
        traderUser.setBalance(traderBalance + trade.getAmount());
        userDao.updateUser(traderUser);//加钱
        Trade trade1 = new Trade();
        trade1.setUserId(trade.getTrader());
        trade1.setAmount(trade.getAmount());
        trade1.setTrader(trade.getUserId());
        trade1.setType(Constans.TRADE_IN);
        trade1.setBalance(traderUser.getBalance());
        tradeDao.addTrade(trade1);

    }
}
