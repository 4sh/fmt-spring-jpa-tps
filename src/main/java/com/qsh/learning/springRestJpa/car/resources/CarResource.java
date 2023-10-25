package com.qsh.learning.springRestJpa.car.resources;

import com.qsh.learning.springRestJpa.car.services.CarService;
import com.qsh.learning.springRestJpa.core.config.models.CurrentCarIdHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarResource {

    private CarService carService;

    private CurrentCarIdHolder currentCarIdHolder;

    public CarResource(
            CarService carService,
            CurrentCarIdHolder currentCarIdHolder
    ) {
        this.carService = carService;
        this.currentCarIdHolder = currentCarIdHolder;
    }

    @GetMapping("")
    public String find() {
        return this.carService.find();
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") String carId) {

        System.out.println(String.format("Ancienne valeur de car id: %s", currentCarIdHolder.getCarId()));
        currentCarIdHolder.setCarId(carId);
        System.out.println(String.format("Nouvelle valeur de car id: %s", currentCarIdHolder.getCarId()));

        return this.carService.find();
    }
}
