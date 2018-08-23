package com.ssm.cloud.dao;

import com.ssm.cloud.pojo.CloudDir;

import java.util.List;

public interface CloudDirDao {

    void addDir(CloudDir cloudDir);
    void delDir(CloudDir cloudDir);
    void updateDir(CloudDir cloudDir);

    List<CloudDir> getDirList(int userId);

    CloudDir getDirById(int id);

}
