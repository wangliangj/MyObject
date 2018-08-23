package com.ssm.animal.service;

import com.github.pagehelper.PageInfo;
import com.ssm.animal.pojo.Animal;

import java.util.Map;

public interface AnimalService {
    void addAnimal(Animal animal);

    PageInfo<Animal> getAnimalList(Map<String, Object> param, int pageNum, int pageSize);
}
