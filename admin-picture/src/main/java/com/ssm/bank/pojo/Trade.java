package com.ssm.bank.pojo;

import com.ssm.bank.util.Constans;

import java.sql.Date;

public class Trade {
    private Integer id;
    private Date createdDate;
    private Integer userId;
    private  Integer type;
    private Integer amount;
    private Integer balance;
    private String remark;
    private Integer trader;


    public String getTypeString() {
        switch (this.getType()) {
            case Constans.TRADE_SAVE:
                return "存款";
            case Constans.TRADE_BUY:
                return "消费";
            case Constans.TRADE_IN:
                return "转入";
            case Constans.TRADE_OUT:
                return "转出";
            default:
                return "--";
        }

    }

    public Integer getType() {
        return type;
    }

    public Trade setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getBalance() {
        return balance;
    }

    public Trade setBalance(Integer balance) {
        this.balance = balance;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Trade setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Trade setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Trade setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }



    public Integer getAmount() {
        return amount;
    }

    public Trade setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }



    public String getRemark() {
        return remark;
    }

    public Trade setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getTrader() {
        return trader;
    }

    public Trade setTrader(Integer trader) {
        this.trader = trader;
        return this;
    }
}
