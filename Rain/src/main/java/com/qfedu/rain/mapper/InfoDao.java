package com.qfedu.rain.mapper;

import com.qfedu.rain.pojo.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoDao {

    int insertInfo(Info info);

    int updateInfo(Info info);

    int deleteInfo(@Param("id") Long id);

    Info selectInfoById(@Param("id") Long id);

    List<Info> selectInfoAll();


    List<Info> findInfoByPage(@Param("start") int start, @Param("pageSize") int pageSize);
    Integer findInfoCount();

    List<Info> findInfopageByArea(@Param("start") int start, @Param("pageSize") int pageSize, @Param("area") String area);
    Integer findInfoCountByArea( @Param("area") String area);

}
