package com.ssm.animals.pojo;

import java.util.Date;

public class Animal {
    private Integer id;
    private String name;
    private Date birthday;
    private  String sex;
    private String description;
    private String kind;

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Animal setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Animal setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Animal setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public Animal setKind(String kind) {
        this.kind = kind;
        return this;
    }
}
