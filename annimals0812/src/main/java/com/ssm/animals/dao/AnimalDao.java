package com.ssm.animals.dao;

import com.ssm.animals.pojo.Animal;

import java.util.List;

public interface AnimalDao {

    void addAnimals(Animal animal);

    void deleteAnimals(Integer id);

    void updateAnimals(Animal animal);

    List<Animal> selectAll();

}
