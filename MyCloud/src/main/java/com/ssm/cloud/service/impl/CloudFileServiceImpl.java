package com.ssm.cloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.cloud.dao.CloudFileDao;
import com.ssm.cloud.pojo.CloudFile;
import com.ssm.cloud.service.CloudFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CloudFileServiceImpl implements CloudFileService {

    @Autowired
    private CloudFileDao cloudFileDao;

    @Override
    public void addFile(CloudFile cloudFile) {
        cloudFileDao.addFile(cloudFile);
    }

    @Override
    public void deleteFile(Integer id) {
        cloudFileDao.deleteFile(id);
    }

    @Override
    public List<CloudFile> getFileById(Integer userId, Integer dirId) {
        List<CloudFile> fileList = cloudFileDao.getFileById(userId, dirId);

        return fileList;
    }


    @Override
    public PageInfo<CloudFile> getFileList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CloudFile> list = cloudFileDao.getFileList(param);
        PageInfo<CloudFile> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }
}
