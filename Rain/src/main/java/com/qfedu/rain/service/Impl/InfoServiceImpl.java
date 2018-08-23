package com.qfedu.rain.service.Impl;


import com.qfedu.rain.bean.PageInfo;
import com.qfedu.rain.mapper.InfoDao;
import com.qfedu.rain.mapper.StationDao;
import com.qfedu.rain.pojo.Info;
import com.qfedu.rain.pojo.Station;
import com.qfedu.rain.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoDao infoDao;
    @Autowired
    private StationDao stationDao;


    @Override
    public int addInfo(Info info) {

        return  infoDao.insertInfo(info);
    }

    @Override
    public int removeInfo(Long id) {
        return infoDao.deleteInfo(id);
    }

    @Override
    public int updateInfo(Info info) {
        return infoDao.updateInfo(info);
    }


    @Override
    public Info findInfoById(Long id) {

        return  infoDao.selectInfoById(id);
    }

    @Override
    public List<Info> findInfoAll() {

        return  infoDao.selectInfoAll();
    }

    @Override
    public PageInfo<Info> getInfoByPage(int pageNo, int pageSize) {
        PageInfo<Info> pageInfo = new PageInfo<>();
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        Integer count = infoDao.findInfoCount();
        int pageSum =(int)((count/pageSize)+(count%pageSize==0?0:1));
        List<Info> infos = infoDao.findInfoByPage((pageNo - 1) * pageSize, pageSize);
        for (int i = 0; infos!=null&&i < infos.size(); i++) {
            Info info = infos.get(i);
            Station station = stationDao.selectOneById(info.getSid());
            info.setStation(station);
        }
        pageInfo.setList(infos);
        pageInfo.setPageSum(pageSum);

        return pageInfo;
    }

    @Override
    public PageInfo<Info> getInfoPageByArea(int pageNo, int pageSize, String area) {
        PageInfo<Info> pageInfo = new PageInfo<>();
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        area = "%" + area + "%";

        Integer count = infoDao.findInfoCountByArea(area);
        int pageSum = (int) ((count / pageSize) + (count % pageSize == 0 ? 0 : 1));
        List<Info> list = infoDao.findInfopageByArea((pageNo - 1) * pageSize, pageSize, area);
        for (int i = 0; list!=null&&i < list.size(); i++) {
            Info info = list.get(i);
            Station station = stationDao.selectOneById(info.getSid());
            info.setStation(station);

        }
        pageInfo.setPageSum(pageSum);
        pageInfo.setList(list);
        return pageInfo;
    }
}
