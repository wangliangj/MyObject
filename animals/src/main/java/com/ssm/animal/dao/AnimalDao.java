package com.ssm.animal.dao;

import com.ssm.animal.pojo.Animal;

import java.util.List;
import java.util.Map;

public interface AnimalDao {

    void addAnimal(Animal animal);

    List<Animal> getAnimalList(Map<String, Object> param);

}
