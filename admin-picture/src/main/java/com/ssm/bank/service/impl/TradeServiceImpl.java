package com.ssm.bank.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.bank.dao.TradeDao;
import com.ssm.bank.pojo.Trade;
import com.ssm.bank.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeDao tradeDao;



    @Override
    public PageInfo<Trade> getTradeList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Trade> pageInfo = new PageInfo<>(tradeDao.getTradeList(param));
        return pageInfo;
    }
}
