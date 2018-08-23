package com.qfedu.rain.service;

import com.qfedu.rain.pojo.Station;

import java.util.List;

public interface StationService {

    int addStation(String  name);

    int removeStation(Long id);

    Station findStationById(Long id);

    List<Station> findAllStation();




}
