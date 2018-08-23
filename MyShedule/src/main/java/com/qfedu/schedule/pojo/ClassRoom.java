package com.qfedu.schedule.pojo;

public class ClassRoom {

    private  Integer id;
    private String name;

    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public ClassRoom setClasses(Classes classes) {
        this.classes = classes;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public ClassRoom setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClassRoom setName(String name) {
        this.name = name;
        return this;
    }
}
