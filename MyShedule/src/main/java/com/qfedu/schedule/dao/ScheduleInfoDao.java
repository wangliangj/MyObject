package com.qfedu.schedule.dao;

import com.qfedu.schedule.pojo.ScheduleInfo;
import org.apache.ibatis.annotations.Param;

public interface ScheduleInfoDao {

    ScheduleInfo selectOneByClassName(@Param("className") String className);


}
