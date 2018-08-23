package com.qfedu.rain.service;

import com.qfedu.rain.bean.PageInfo;
import com.qfedu.rain.pojo.Info;

import java.util.List;

public interface InfoService {

    int addInfo(Info info);

    int removeInfo(Long id);

     int updateInfo(Info info);


    Info findInfoById(Long id);

    List<Info> findInfoAll();

    PageInfo<Info> getInfoByPage(int pageNo, int pageSize);

    PageInfo<Info> getInfoPageByArea(int pageNo, int pageSize, String area);

}
