package com.qfedu.rain.mapper;

import com.qfedu.rain.pojo.Station;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StationDao {

    //增加
    int insertStation(Station station);

    //删除
    int deleteStation(@Param("id") Long id);

    //修改
    Station updateStation();

    //查找
    Station selectOneById(@Param("id") Long id);

    List<Station> selectAllStation();

}
