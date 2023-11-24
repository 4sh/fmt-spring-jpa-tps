package com.qsh.learning.springRestJpa.car.repositories;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import com.qsh.learning.springRestJpa.car.models.entities.CarSummary;
import com.qsh.learning.springRestJpa.car.models.entities.LicensePlate;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String>, CarRepositoryCustom {
    @EntityGraph(value = "Car.technicalControls", type = EntityGraph.EntityGraphType.LOAD)
    List<Car> findAllByCarDescription_Color(Color color);

    @Query("""
        SELECT lp FROM LicensePlate lp
        INNER JOIN Car c ON lp.id = c.licensePlate.id
        WHERE c.carDescription.color = :color
    """)
    List<LicensePlate> findAlLLicensePlatesByCarColor(Color color);

    @Query("""
        SELECT c.carDescription.brand as brand, c.numberOfSeats as numberOfSeats FROM Car c
    """)
    List<CarSummary> getCarSummaries();
}
