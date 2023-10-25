package com.qsh.learning.springRestJpa.core.car.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarResource {
    // À compléter lors de la partie 1 du TP 1


    // À décommenter lors de la partie 3 du TP 1
//    @GetMapping("/{id}")
//    public void findById(@PathVariable("id") String carId) {
//
//        System.out.println(String.format("Ancienne valeur de car id: %s", currentCarIdHolder.getCarId()));
//        currentCarIdHolder.setCarId(carId);
//        System.out.println(String.format("Nouvelle valeur de car id: %s", currentCarIdHolder.getCarId()));
//        this.carService.find();
//    }
}
