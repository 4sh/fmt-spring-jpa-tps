package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.car.exceptions.CarNotFoundException;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import com.qsh.learning.springRestJpa.car.repositories.CarEntityManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements VehicleService {

    private final CarEntityManagerRepository carEntityManagerRepository;

    public CarService(CarEntityManagerRepository carEntityManagerRepository) {
        this.carEntityManagerRepository = carEntityManagerRepository;
    }

    @Override
    public List<Car> findAll() {
        return this.carEntityManagerRepository.getCars();
    }

    @Override
    public Car findById(String id) {
        Car car = this.carEntityManagerRepository.findById(id);
        if (null == car) {
            throw new CarNotFoundException(String.format("Car %s not found", id));
        }
        return car;
    }

    @Override
    public Car create(Car car) {
        this.carEntityManagerRepository.create(car);
        return car;
    }

    @Override
    public Car update(String id, Car car) {
        this.carEntityManagerRepository.update(car);
        return car;
    }

    @Override
    public void delete(String id) {
        this.carEntityManagerRepository.delete(id);
    }
}
