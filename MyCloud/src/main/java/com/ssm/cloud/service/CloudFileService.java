package com.ssm.cloud.service;

import com.github.pagehelper.PageInfo;
import com.ssm.cloud.pojo.CloudFile;

import java.util.List;
import java.util.Map;

public interface CloudFileService {

    void addFile(CloudFile cloudFile);

    void deleteFile(Integer id);

    List<CloudFile> getFileById(Integer userId,Integer dirId);

    PageInfo<CloudFile> getFileList(Map<String, Object> param, int pageNum, int pageSize);


}
