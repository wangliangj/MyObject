package com.qfedu.schedule.pojo;

public class Schedule {
    private Integer id;
    private Integer classId;
    private Integer roomId;
    private String course;
    private String workday;
    private Integer sort;



    public Integer getId() {
        return id;
    }

    public Schedule setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getClassId() {
        return classId;
    }

    public Schedule setClassId(Integer classId) {
        this.classId = classId;
        return this;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Schedule setRoomId(Integer roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public Schedule setCourse(String course) {
        this.course = course;
        return this;
    }

    public String getWorkday() {
        return workday;
    }

    public Schedule setWorkday(String workday) {
        this.workday = workday;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public Schedule setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
}
