package com.qfedu.rain.service.Impl;

import com.qfedu.rain.mapper.StationDao;
import com.qfedu.rain.pojo.Station;
import com.qfedu.rain.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao stationDao;

    @Override
    public int addStation(String name) {
        Station station = new Station();
        station.setName(name);
        return  stationDao.insertStation(station);
    }

    @Override
    public int removeStation(Long id) {
        return stationDao.deleteStation(id);
    }

    @Override
    public Station findStationById(Long id) {
        Station station = stationDao.selectOneById(id);
        return station;
    }

    @Override
    public List<Station> findAllStation() {
        List<Station> stations = stationDao.selectAllStation();
        return stations;
    }
}
