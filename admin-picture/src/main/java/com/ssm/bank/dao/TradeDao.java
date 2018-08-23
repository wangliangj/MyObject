package com.ssm.bank.dao;

import com.ssm.bank.pojo.Trade;

import java.util.List;
import java.util.Map;

public interface TradeDao {

    void addTrade(Trade trade);

    List<Trade> getTradeList(Map<String, Object> param);

}
