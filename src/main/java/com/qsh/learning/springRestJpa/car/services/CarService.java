package com.qsh.learning.springRestJpa.car.services;

import org.springframework.stereotype.Service;

@Service
public class CarService implements VehicleService {

    public String find() {
        return "Car 1";
    }
}
