package com.ssm.cloud.dao;


import com.ssm.cloud.pojo.CloudFile;

import java.util.List;
import java.util.Map;

public interface CloudFileDao {

    void addFile(CloudFile cloudFile);

    void deleteFile(Integer id);

    List<CloudFile> getFileById(Integer userId,Integer dirId);

    List<CloudFile> getFileList(Map<String, Object> param);

}
