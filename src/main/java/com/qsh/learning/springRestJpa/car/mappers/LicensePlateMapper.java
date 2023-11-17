package com.qsh.learning.springRestJpa.car.mappers;

import com.qsh.learning.springRestJpa.car.models.dtos.LicensePlateDto;
import com.qsh.learning.springRestJpa.car.models.entities.LicensePlate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LicensePlateMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "licensePlateNumber", source = "licensePlateNumber"),
            @Mapping(target = "country", source = "country")
    })
    LicensePlateDto entityToDto(LicensePlate licensePlate);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "licensePlateNumber", source = "licensePlateNumber"),
            @Mapping(target = "country", source = "country")
    })
    LicensePlate dtoToEntity(LicensePlateDto licensePlateDto);
}
