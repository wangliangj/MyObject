package com.qfedu.schedule.dao;

import com.qfedu.schedule.pojo.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesDao {
    Classes selectClassesById(@Param("id") Integer id);

    List<Classes> selectClassesAll();


}
