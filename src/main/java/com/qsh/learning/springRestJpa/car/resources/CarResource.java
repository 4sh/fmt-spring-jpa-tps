package com.qsh.learning.springRestJpa.car.resources;

import com.qsh.learning.springRestJpa.car.models.Car;
import com.qsh.learning.springRestJpa.car.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
public class CarResource {

    public final CarService carService;

    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<Car> findAll(
            @RequestParam(value = "color", required = false) String color
    ) {
        List<Car> cars = this.carService.findAll();

        if (null != color) {
            return cars.stream()
                    .filter(car -> Objects.equals(car.getColor(), color))
                    .collect(Collectors.toList());
        } else {
            return cars;
        }
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable("id") String id) {
        return this.carService.findById(id);
    }

    @PostMapping("")
    public Car create(@RequestBody Car car) {
        return this.carService.create(car);
    }

    @PutMapping("/{id}")
    public Car update(
            @PathVariable("id") String id,
            @RequestBody Car car
    ) {
        car.setId(id);
        return this.carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") String id
    ) {
        this.carService.delete(id);
    }
}
