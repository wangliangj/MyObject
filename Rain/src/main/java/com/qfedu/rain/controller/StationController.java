package com.qfedu.rain.controller;

import com.google.gson.Gson;
import com.qfedu.rain.pojo.Station;
import com.qfedu.rain.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class StationController {
    @Autowired
    private StationService stationService;


    @RequestMapping("/addstation")
    public String addstation() {
        return "addstation";
    }


    @RequestMapping("/addstations")
    public String addStations(
            @RequestParam("name")String name,
            HttpServletRequest request
    ) {
        int result = stationService.addStation(name);
        List<Station> stations = stationService.findAllStation();

        if (result > 0) {
            request.setAttribute("stations",stations);
            return "stationlist";
        }

        return "error";
    }

    @RequestMapping("/backstationlist")
    public String backstationlist() {
        return "stationlist";
    }


    @RequestMapping(value = "/showstationlist",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public void showstationlist(
            HttpServletResponse response
    ) throws IOException {

        List<Station> stations = stationService.findAllStation();

        response.getWriter().write(new Gson().toJson(stations));

    }

    @RequestMapping("/deletestation")
    public String  deleteStation(
            @RequestParam("id")Long id
    ) {
        stationService.removeStation(id);

        return "stationlist";
    }

    @RequestMapping("/stationlist")
    public String stationlist() {
        return "stationlist";
    }





}
