package com.qsh.learning.springRestJpa.car.repositories;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.models.entities.*;
import com.qsh.learning.springRestJpa.car.models.entities.LicensePlate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarEntityManagerRepository {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    public CarEntityManagerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Transactional
    public List<Car> getCars() {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("Car.technicalControls");

        return jpaQueryFactory.selectFrom(QCar.car)
                .setHint("jakarta.persistence.loadgraph", entityGraph)
                .fetch();
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
        QLicensePlate licensePlate = QLicensePlate.licensePlate;
        QCar car = QCar.car;

        return jpaQueryFactory
                .selectFrom(licensePlate)
                .from(licensePlate)
                .join(car)
                .on(car.licensePlate.id.eq(licensePlate.id))
                .where(car.carDescription.color.eq(color))
                .fetch();
    }
}