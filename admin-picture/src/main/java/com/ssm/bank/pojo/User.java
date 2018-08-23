package com.ssm.bank.pojo;

public class User {
    private Integer id;
    private String  cardId;
    private String password;
    private Integer balance;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCardId() {
        return cardId;
    }

    public User setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getBalance() {
        return balance;
    }

    public User setBalance(Integer balance) {
        this.balance = balance;
        return this;
    }
}
