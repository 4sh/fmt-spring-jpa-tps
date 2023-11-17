package com.qsh.learning.springRestJpa.car.repositories;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.models.entities.*;
import com.qsh.learning.springRestJpa.car.models.entities.LicensePlate;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarEntityManagerRepository {

    private final EntityManager entityManager;

    public CarEntityManagerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Car> getCars() {
        return this.entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    }

    @Transactional
    public Car findById(String id) {
        return this.entityManager.find(Car.class, id);
    }

    @Transactional
    public void create(Car car) {
        entityManager.persist(car);
    }

    @Transactional
    public void update(Car car) {
        entityManager.merge(car);
    }

    @Transactional
    public void delete(String carId) {
        Car car = this.findById(carId);
        entityManager.remove(car);
    }

    @Transactional
    public List<LicensePlate> getLicensePlates(Color color) {
        return this.entityManager.createQuery("""
                            SELECT lp FROM LicensePlate lp INNER JOIN Car c ON lp.id = c.licensePlate.id WHERE c.carDescription.color = :color
                        """, LicensePlate.class)
                .setParameter("color", color)
                .getResultList();
    }
}