package com.qsh.learning.springRestJpa.car.mappers;

import com.qsh.learning.springRestJpa.car.factories.CarFactory;
import com.qsh.learning.springRestJpa.car.models.dtos.CarDto;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { CarFactory.class })
public interface CarMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "brand", source = "brand"),
            @Mapping(target = "model", source = "model"),
            @Mapping(target = "color", source = "color"),
            @Mapping(target = "numberOfDoors", source = "numberOfDoors"),
            @Mapping(target = "numberOfSeats", source = "numberOfSeats"),
            @Mapping(target = "catalogReference", ignore = true),
    })
    CarDto entityToDto(Car car);

    Car dtoToEntity(CarDto carDto);
}
