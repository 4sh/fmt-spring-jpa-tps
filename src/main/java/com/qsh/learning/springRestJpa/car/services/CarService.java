package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.core.config.annotations.Supervised;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class CarService implements VehicleService {

    @Supervised
    public String find() {
        return "Car 1";
    }
}
