package com.qfedu.schedule.pojo;

import java.util.List;

public class Classes {
    private Integer id;
    private String name;
    private List<ClassRoom> classRooms;

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public Classes setClassRooms(List<ClassRoom> classRooms) {
        this.classRooms = classRooms;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Classes setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Classes setName(String name) {
        this.name = name;
        return this;
    }
}
