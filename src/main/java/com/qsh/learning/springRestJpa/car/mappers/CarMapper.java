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
            @Mapping(target = "brand", source = "carDescription.brand"),
            @Mapping(target = "model", source = "carDescription.model"),
            @Mapping(target = "color", source = "carDescription.color"),
            @Mapping(target = "numberOfDoors", source = "numberOfDoors"),
            @Mapping(target = "numberOfSeats", source = "numberOfSeats"),
            @Mapping(target = "licensePlate", source = "licensePlate"),
            @Mapping(target = "technicalControls", source = "technicalControls"),
            @Mapping(target = "drivers", source = "drivers"),
            @Mapping(target = "catalogReference", ignore = true),
    })
    CarDto entityToDto(Car car);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "carDescription.brand", source = "brand"),
            @Mapping(target = "carDescription.model", source = "model"),
            @Mapping(target = "carDescription.color", source = "color"),
            @Mapping(target = "numberOfDoors", source = "numberOfDoors"),
            @Mapping(target = "numberOfSeats", source = "numberOfSeats"),
            @Mapping(target = "licensePlate", source = "licensePlate"),
            @Mapping(target = "technicalControls", source = "technicalControls"),
            @Mapping(target = "drivers", source = "drivers"),
    })
    Car dtoToEntity(CarDto carDto);
}
