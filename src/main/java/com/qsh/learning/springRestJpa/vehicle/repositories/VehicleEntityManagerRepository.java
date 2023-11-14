package com.qsh.learning.springRestJpa.vehicle.repositories;

import com.qsh.learning.springRestJpa.vehicle.models.entities.Trailer;
import com.qsh.learning.springRestJpa.vehicle.models.entities.Truck;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleEntityManagerRepository {

    private final EntityManager entityManager;

    public VehicleEntityManagerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Truck> getTrucks() {
        return this.entityManager.createQuery("SELECT v FROM Truck v").getResultList();
    }

    @Transactional
    public List<Trailer> getTrailers() {
        return this.entityManager.createQuery("SELECT v FROM Trailer v").getResultList();
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
