package com.qsh.learning.springRestJpa.car.resources;

import com.qsh.learning.springRestJpa.car.services.VehicleService;
import com.qsh.learning.springRestJpa.core.config.models.CurrentCarIdHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarResource {

    private final VehicleService vehicleService;

    private final CurrentCarIdHolder currentCarIdHolder;

    public CarResource(
            VehicleService vehicleService,
            CurrentCarIdHolder currentCarIdHolder
    ) {
        this.vehicleService = vehicleService;
        this.currentCarIdHolder = currentCarIdHolder;
    }

    @GetMapping("")
    public String find() {
        return this.vehicleService.find();
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") String carId) {

        System.out.printf("Current user: %s%n", currentCarIdHolder.getId());

        return this.vehicleService.find();
    }
}
