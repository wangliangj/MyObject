package com.qfedu.schedule.dao;

import com.qfedu.schedule.pojo.Schedule;
import org.apache.ibatis.annotations.Param;

public interface ScheduleDao {
    Schedule selectScheduleByClassId(@Param("classId")Integer classId);
    Schedule selectScheduleByRoomId(@Param("RoomId")Integer RoomId);




}
