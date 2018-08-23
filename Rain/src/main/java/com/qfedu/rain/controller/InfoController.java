package com.qfedu.rain.controller;

import com.google.gson.Gson;
import com.qfedu.rain.bean.PageInfo;
import com.qfedu.rain.pojo.Info;
import com.qfedu.rain.pojo.Station;
import com.qfedu.rain.service.InfoService;
import com.qfedu.rain.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class InfoController {
    @Autowired
    private InfoService infoService;

    @Autowired
    private StationService stationService;

    @RequestMapping("/info")
    public String info() {
        return "info";
    }

    @RequestMapping("/addinfo")
    public String addInfo(
            HttpServletRequest request
    ) {
        List<Station> allStation = stationService.findAllStation();
        request.setAttribute("allStation",allStation);
        return "addinfo";
    }



    @RequestMapping("/addinfos")
    public String addInfos(
            @RequestParam("area") String area,
            @RequestParam("maxrainfall") String maxrainfall,
            @RequestParam("minrainfall") String minrainfall,
            @RequestParam("raintime") String raintime,
            @RequestParam("sid") Long sid,
            HttpServletRequest request
    ) {


        Info info = new Info();
        info.setArea(area);
        info.setMaxrainfall(maxrainfall);
        info.setMinrainfall(minrainfall);
        info.setRaintime(raintime);
        info.setSid(sid);

        int result = infoService.addInfo(info);
        if (result > 0) {
            return "info";
        }
        return "error";
    }

    @RequestMapping("/showrainbypage")
    public void showRainBypage(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("pageSize") int pageSize,
            HttpServletResponse response
    ) throws IOException {

        PageInfo<Info> pageInfo = infoService.getInfoByPage(pageNo, pageSize);
        Gson gson = new Gson();
        response.setContentType("text/html,charset=utf-8");
        response.getWriter().write(gson.toJson(pageInfo));
    }


    @RequestMapping("/showrainbyareapage")
    public void showInfoByAreapage(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("area")String area,
            HttpServletResponse response
    ) throws IOException {

        PageInfo<Info> pageInfo = infoService.getInfoPageByArea(pageNo, pageSize, area);
        Gson gson = new Gson();
        response.setContentType("text/html,charset=utf-8");
        response.getWriter().write(gson.toJson(pageInfo));
    }

    @RequestMapping("/deleteinfo")
    public String  deleteInfo(

            @RequestParam("id") Long id
    ){
        infoService.removeInfo(id);
        return "info";
    }

    @RequestMapping("/editinfo")
    public String  editinfo(
            @RequestParam("id") Long id
    ){
        Info info = new Info();
        info.setId(id);
        infoService.updateInfo(info);
        return "editinfo";
    }

    @RequestMapping("/doeditinfo")
    public String editInfo(
            @RequestParam("area") String area,
            @RequestParam("maxrainfall") String maxrainfall,
            @RequestParam("minrainfall") String minrainfall,
            @RequestParam("raintime") String raintime,
            @RequestParam("sid") Long sid,
            @RequestParam("id") Long id
    ) {

        Info info = new Info();
        info.setId(id);
        info.setSid(sid);
        info.setArea(area);

        int result = infoService.updateInfo(info);
        if (result > 0) {
            return "info";
        }

        return "error";
    }

}
