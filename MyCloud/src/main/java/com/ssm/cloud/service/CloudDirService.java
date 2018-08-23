package com.ssm.cloud.service;

import com.ssm.cloud.pojo.CloudDir;

import java.util.List;

public interface CloudDirService {

    void addDir(CloudDir cloudDir);
    void delDir(CloudDir cloudDir);
    void updateDir(CloudDir cloudDir);
    CloudDir getDirById(int id);
    List<CloudDir> getDirList(int userId);

}
