package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.car.models.Car;

import java.util.List;

public interface VehicleService {

    List<Car> findAll();

    Car findById(String id);

    Car create(Car car);

    Car update(String id, Car car);
}
