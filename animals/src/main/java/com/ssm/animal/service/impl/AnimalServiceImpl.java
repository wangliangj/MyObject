package com.ssm.animal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.animal.dao.AnimalDao;
import com.ssm.animal.pojo.Animal;
import com.ssm.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalDao animalDao;

    @Override
    public void addAnimal(Animal animal) {

        animalDao.addAnimal(animal);

    }

    @Override
    public PageInfo<Animal> getAnimalList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        PageInfo<Animal> pageInfo = new PageInfo<>(animalDao.getAnimalList(param));
        return pageInfo;
    }
}
