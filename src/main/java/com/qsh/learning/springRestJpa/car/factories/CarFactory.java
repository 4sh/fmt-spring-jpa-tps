package com.qsh.learning.springRestJpa.car.factories;

import com.qsh.learning.springRestJpa.car.models.dtos.CarDto;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
public class CarFactory {

    @AfterMapping
    public void fillCatalogReference(
            Car car,
            @MappingTarget CarDto carDto
    ) {
        carDto.setCatalogReference(car.getBrand()+"_"+car.getModel());
    }
}