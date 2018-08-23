package com.ssm.cloud.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CloudFile {

    private Integer id;
    private String name;
    private Long size;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private Integer userId;
    private Integer dirId;

    public Integer getId() {
        return id;
    }

    public CloudFile setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CloudFile setName(String name) {
        this.name = name;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public CloudFile setSize(Long size) {
        this.size = size;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public CloudFile setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public CloudFile setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getDirId() {
        return dirId;
    }

    public CloudFile setDirId(Integer dirId) {
        this.dirId = dirId;
        return this;
    }
}
