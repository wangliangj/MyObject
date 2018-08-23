package com.ssm.cloud.controller;

import com.ssm.cloud.pojo.CloudDir;
import com.ssm.cloud.pojo.User;
import com.ssm.cloud.service.CloudDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dir")
public class CloudDirController {
    @Autowired
    private CloudDirService cloudDirService;


    @RequestMapping("list.html")
    public ModelAndView list(HttpSession session) {
        User user = (User) session.getAttribute("SESSION_USER");
        List<CloudDir> dirList = cloudDirService.getDirList(user.getId());

        return new ModelAndView("folder_list", "dirlist", dirList);
    }

    @RequestMapping("add.html")
    @ResponseBody
    public Map<String ,Object> add(String name,HttpSession session) {
        User user = (User) session.getAttribute("SESSION_USER");
        CloudDir cloudDir = new CloudDir();
        cloudDir.setName(name);
        cloudDir.setUserId(user.getId());
        cloudDir.setUpdateTime(new Date());
        cloudDirService.addDir(cloudDir);
        Map<String, Object> result = new HashMap<>();
        result.put("cloudDir", cloudDir);
        result.put("status", true);
        return result;

    }

    @RequestMapping("update.html")
    @ResponseBody
    public Map<String ,Object> update(CloudDir dir,HttpSession session) {
        User user = (User) session.getAttribute("SESSION_USER");
        dir.setUserId(user.getId());
        /*dir.setUpdateTime(new Date());*/
        cloudDirService.updateDir(dir);
        Map<String, Object> result = new HashMap<>();
        result.put("dir", dir);
        result.put("status" ,true);
        return result;


    }

    @RequestMapping("delete.html")
    @ResponseBody
    public Map<String ,Object> delete(Integer id,HttpSession session) {
        User user = (User) session.getAttribute("SESSION_USER");
        CloudDir dir = cloudDirService.getDirById(id);
        cloudDirService.delDir(dir);
        Map<String, Object> result = new HashMap<>();
        result.put("status", true);
        return result;


    }
}
