package com.ssm.bank.service;

import com.github.pagehelper.PageInfo;
import com.ssm.bank.pojo.Trade;

import java.util.Map;

public interface TradeService {


    PageInfo<Trade> getTradeList(Map<String, Object> param, int pageNum, int pageSize);

}
