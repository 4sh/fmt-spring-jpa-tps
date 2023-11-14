package com.qsh.learning.springRestJpa.vehicle.services;

import com.qsh.learning.springRestJpa.vehicle.models.entities.Trailer;
import com.qsh.learning.springRestJpa.vehicle.models.entities.Truck;
import com.qsh.learning.springRestJpa.vehicle.repositories.VehicleEntityManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleEntityManagerRepository entityManagerRepository;

    public VehicleService(VehicleEntityManagerRepository entityManagerRepository) {
        this.entityManagerRepository = entityManagerRepository;
    }

    public List<Truck> getAllTruck() {
        return this.entityManagerRepository.getTrucks();
    }

    public void createTruck(Truck truck) {
        this.entityManagerRepository.createTruck(truck);
    }

    public List<Trailer> getAllTrailer() {
        return this.entityManagerRepository.getTrailers();
    }

    public void createTrailer(Trailer trailer) {
        this.entityManagerRepository.createTrailer(trailer);
    }
}
