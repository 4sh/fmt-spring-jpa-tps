package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.car.exceptions.CarNotFoundException;
import com.qsh.learning.springRestJpa.car.models.Car;
import com.qsh.learning.springRestJpa.car.repositories.CarFileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements VehicleService {

    public final CarFileRepository carFileRepository;

    public CarService(CarFileRepository carFileRepository) {
        this.carFileRepository = carFileRepository;
    }

    @Override
    public List<Car> findAll() {
        return this.carFileRepository.getCars();
    }

    @Override
    public Car findById(String id) {
        Car car = this.carFileRepository.findById(id);
        if (null == car) {
            throw new CarNotFoundException(String.format("Car %s not found", id));
        }
        return car;
    }

    @Override
    public Car create(Car car) {
        this.carFileRepository.create(car);

        System.out.printf("Car %s has been created\n", car.getId());
        return car;
    }

    @Override
    public Car update(String id, Car car) {
        this.carFileRepository.update(car);

        System.out.printf("Car %s has been updated\n", car.getId());
        return car;
    }

    @Override
    public void delete(String id) {
        this.carFileRepository.delete(id);

        System.out.printf("Car %s has been deleted\n", id);
    }
}
