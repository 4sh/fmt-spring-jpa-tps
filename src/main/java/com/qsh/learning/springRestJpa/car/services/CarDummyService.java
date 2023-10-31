package com.qsh.learning.springRestJpa.car.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class CarDummyService implements VehicleService {

    public String find() {
        return "Dummy Car 1";
    }
}