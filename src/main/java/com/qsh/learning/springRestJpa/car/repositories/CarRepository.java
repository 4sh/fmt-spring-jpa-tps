package com.qsh.learning.springRestJpa.car.repositories;

import com.qsh.learning.springRestJpa.car.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}
