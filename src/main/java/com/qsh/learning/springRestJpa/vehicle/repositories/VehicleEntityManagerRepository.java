package com.qsh.learning.springRestJpa.vehicle.repositories;

import com.qsh.learning.springRestJpa.vehicle.models.entities.Trailer;
import com.qsh.learning.springRestJpa.vehicle.models.entities.Truck;
import com.qsh.learning.springRestJpa.vehicle.models.entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleEntityManagerRepository {

    private final EntityManager entityManager;

    public VehicleEntityManagerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Truck> getTrucks() {
        List<Vehicle> vehicles = this.entityManager.createQuery("SELECT v FROM Vehicle v").getResultList();
        return vehicles.stream()
                .filter(vehicle -> vehicle instanceof Truck)
                .map(vehicle -> (Truck) vehicle)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Trailer> getTrailers() {
        return this.entityManager.createQuery("SELECT t FROM Trailer t").getResultList();
    }

    @Transactional
    public void createTruck(Truck truck) {
        entityManager.persist(truck);
    }

    @Transactional
    public void createTrailer(Trailer trailer) {
        entityManager.persist(trailer);
    }

}
