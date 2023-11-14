package com.qsh.learning.springRestJpa.vehicle.mappers;

import com.qsh.learning.springRestJpa.vehicle.models.dtos.TrailerDto;
import com.qsh.learning.springRestJpa.vehicle.models.dtos.TruckDto;
import com.qsh.learning.springRestJpa.vehicle.models.entities.Trailer;
import com.qsh.learning.springRestJpa.vehicle.models.entities.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {

    TruckDto entityToDto(Truck truck);

    Truck dtoToEntity(TruckDto truckDto);

    TrailerDto entityToDto(Trailer trailer);

    Trailer dtoToEntity(TrailerDto trailerDto);
}
