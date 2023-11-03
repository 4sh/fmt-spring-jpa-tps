package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.car.models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarService implements VehicleService {

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("1", "ferrari", "296GTS", "red", 3, 2));
        cars.add(new Car("2", "mercedes", "GLA", "blue", 5, 5));
        return cars;
    }

    @Override
    public Car findById(String id) {
        if (Objects.equals(id, "1")) {
            return new Car("1", "ferrari", "296GTS", "red", 3, 2);
        } else if (Objects.equals(id, "2")) {
            return new Car("2", "mercedes", "GLA", "blue", 5, 5);
        } else {
            return new Car("-1", "unknown", "unknown", "unknown", -1, -1);
        }
    }

    @Override
    public Car create(Car car) {
        System.out.printf("Car %s has been created\n", car.getId());
        return car;
    }

    @Override
    public Car update(String id, Car car) {
        Car carToUpdate = this.findById(car.getId());

        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setColor(car.getColor());
        carToUpdate.setNumberOfDoors(car.getNumberOfDoors());
        carToUpdate.setNumberOfSeats(car.getNumberOfSeats());

        System.out.printf("Car %s has been updated\n", carToUpdate.getId());
        return carToUpdate;
    }
}
