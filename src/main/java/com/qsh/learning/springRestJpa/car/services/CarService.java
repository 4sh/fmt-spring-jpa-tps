package com.qsh.learning.springRestJpa.car.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class CarService implements VehicleService {

    public String find() {
        return "Car 1";
    }
}
