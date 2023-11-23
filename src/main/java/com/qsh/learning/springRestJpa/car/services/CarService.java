package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.exceptions.CarNotFoundException;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import com.qsh.learning.springRestJpa.car.models.entities.LicensePlate;
import com.qsh.learning.springRestJpa.car.repositories.CarEntityManagerRepository;
import com.qsh.learning.springRestJpa.car.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarEntityManagerRepository carEntityManagerRepository;

    private final CarRepository carRepository;

    public CarService(
            CarEntityManagerRepository carEntityManagerRepository,
            CarRepository carRepository
    ) {
        this.carEntityManagerRepository = carEntityManagerRepository;
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    public Car findById(String id) {
        return this.carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(String.format("Car %s not found", id)));
    }

    public Car create(Car car) {
        this.carRepository.save(car);
        return car;
    }

    public Car update(String id, Car car) {
        this.carRepository.save(car);
        return car;
    }

    public void delete(String id) {
        this.carRepository.deleteById(id);
    }

    public List<LicensePlate> getLicensePlates(Color color) {
        return this.carEntityManagerRepository.getLicensePlates(color);
    }
}
