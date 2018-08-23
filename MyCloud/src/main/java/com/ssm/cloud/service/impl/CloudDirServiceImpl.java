package com.ssm.cloud.service.impl;

import com.ssm.cloud.dao.CloudDirDao;
import com.ssm.cloud.pojo.CloudDir;
import com.ssm.cloud.service.CloudDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudDirServiceImpl implements CloudDirService {

    @Autowired
    private CloudDirDao cloudDirDao;

    @Override
    public void addDir(CloudDir cloudDir) {
        cloudDirDao.addDir(cloudDir);
    }

    @Override
    public void delDir(CloudDir cloudDir) {
        cloudDirDao.delDir(cloudDir);
    }

    @Override
    public void updateDir(CloudDir cloudDir) {
        cloudDirDao.updateDir(cloudDir);
    }

    @Override
    public CloudDir getDirById(int id) {
        CloudDir dir = cloudDirDao.getDirById(id);
        return dir;
    }

    @Override
    public List<CloudDir> getDirList(int userId) {
        List<CloudDir> list = cloudDirDao.getDirList(userId);
        return list;
    }
}
