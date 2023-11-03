package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.core.config.annotations.Supervised;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class CarDummyService implements VehicleService {

    @Supervised
    public String find() {
        return "Dummy Car 1";
    }
}