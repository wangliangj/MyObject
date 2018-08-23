package com.qfedu.schedule.pojo;

public class ScheduleInfo {

    private String course;
    private String workday;
    private Integer sort;
    private String classesName;
    private String RoomName;



    public String getCourse() {
        return course;
    }

    public ScheduleInfo setCourse(String course) {
        this.course = course;
        return this;
    }

    public String getWorkday() {
        return workday;
    }

    public ScheduleInfo setWorkday(String workday) {
        this.workday = workday;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public ScheduleInfo setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getClassesName() {
        return classesName;
    }

    public ScheduleInfo setClassesName(String classesName) {
        this.classesName = classesName;
        return this;
    }

    public String getRoomName() {
        return RoomName;
    }

    public ScheduleInfo setRoomName(String roomName) {
        RoomName = roomName;
        return this;
    }
}
