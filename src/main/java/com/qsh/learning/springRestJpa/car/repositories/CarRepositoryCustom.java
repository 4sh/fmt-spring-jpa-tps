package com.qsh.learning.springRestJpa.car.repositories;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.models.entities.Car;

import java.util.List;

public interface CarRepositoryCustom {
    List<Car> findAllByColor(Color color);
}
