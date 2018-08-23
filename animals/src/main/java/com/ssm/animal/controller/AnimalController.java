package com.ssm.animal.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.animal.pojo.Animal;
import com.ssm.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;


    @RequestMapping("go{page}.html")
    public String pages(@PathVariable String page) {
        return page;
    }

    @RequestMapping("index.html")
    public ModelAndView index(String kind, @RequestParam(defaultValue = "1") Integer pn, Integer pageSize) {
        Map<String, Object> param = new HashMap<>();
        param.put("kind", kind);
        PageInfo<Animal> pageInfo = animalService.getAnimalList(param, pn, 2);

        return new ModelAndView("index","pageInfo",pageInfo) ;
    }

    @RequestMapping("add.html")
    @ResponseBody
    public Map<String, String> add(String name, String kind, String birthday, String sex, String description) {
        Map<String, String> result = new HashMap<>();
        System.out.println(name+kind+birthday+sex+description);

        if (StringUtils.isEmpty(name)) {
            result.put("error", "昵称不能为空");
            return result;
        }

        Animal animal = new Animal();
        animal.setKind(kind);
        animal.setName(name);
        animal.setDescription(description);
        animal.setBirthday(Date.valueOf(birthday));
        animal.setSex(sex);
        animalService.addAnimal(animal);
        result.put("message", "添加成功");
        return result;
    }

}
