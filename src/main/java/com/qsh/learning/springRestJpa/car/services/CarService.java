package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.exceptions.CarNotFoundException;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import com.qsh.learning.springRestJpa.car.models.entities.CarSummary;
import com.qsh.learning.springRestJpa.car.models.entities.LicensePlate;
import com.qsh.learning.springRestJpa.car.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    private final CarMetricsService carMetricsService;

    public CarService(
            CarRepository carRepository,
            CarMetricsService carMetricsService
    ) {
        this.carRepository = carRepository;
        this.carMetricsService = carMetricsService;
    }

    public List<Car> findAll(Color color) {
        carMetricsService.incrementFindCounter();
        return this.carRepository.findAllByColor(color);
    }

    public Car findById(String id) {
        carMetricsService.incrementFindCounter();
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
        return this.carRepository.findAlLLicensePlatesByCarColor(color);
    }

    public List<CarSummary> getCarSummaries() {
        return this.carRepository.getCarSummaries();
    }
}
