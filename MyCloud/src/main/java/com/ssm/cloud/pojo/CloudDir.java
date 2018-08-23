package com.ssm.cloud.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CloudDir {

    private Integer id;
    private String name;
    private Integer userId;
    private Integer size;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println(multiplus(num));
        System.out.println(String.format("%.2f",10.852539));
    }

    public static int multiplus(int i) {
        if (i == 1) {
            return 1;
        }
        return multiplus(i - 1) * i;
    }
    public String getSizeM() {
        if (this.size == null || this.size == 0)
            return "0KB";
        float tmp = this.size / 1024.0F;
        if (tmp < 1024) {
            return String.format("%.2f",tmp) + "KB";
        }
        tmp /= 1024;//M
        if (tmp < 1024) {
            return String.format("%.2f",tmp) + "M";
        }
        return "0";
    }
}
