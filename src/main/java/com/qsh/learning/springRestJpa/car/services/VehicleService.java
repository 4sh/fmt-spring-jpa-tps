package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.car.models.entities.Car;

import java.util.List;

public interface VehicleService {

    List<Car> findAll();

    Car findById(String id);

    Car create(Car car);

    Car update(String id, Car car);

    void delete(String id);
}
