package com.qsh.learning.springRestJpa.car.repositories;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import com.qsh.learning.springRestJpa.car.models.entities.QCar;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CarRepositoryCustomImpl extends QuerydslRepositorySupport implements CarRepositoryCustom {

    public CarRepositoryCustomImpl() {
        super(Car.class);
    }

    @Override
    public List<Car> findAllByColor(Color color) {
        QCar car = QCar.car;

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (null != color) {
            booleanBuilder.and(car.carDescription.color.eq(color));
        }

        return from(car)
                .where(booleanBuilder)
                .fetch();
    }
}
