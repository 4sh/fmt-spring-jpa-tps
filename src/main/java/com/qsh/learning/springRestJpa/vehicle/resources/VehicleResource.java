package com.qsh.learning.springRestJpa.vehicle.resources;

import com.qsh.learning.springRestJpa.vehicle.mappers.VehicleMapper;
import com.qsh.learning.springRestJpa.vehicle.models.dtos.TrailerDto;
import com.qsh.learning.springRestJpa.vehicle.models.dtos.TruckDto;
import com.qsh.learning.springRestJpa.vehicle.services.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VehicleResource {

    private final VehicleService vehicleService;

    private final VehicleMapper vehicleMapper;

    public VehicleResource(
            VehicleService vehicleService,
            VehicleMapper vehicleMapper
    ) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    @GetMapping("/truck")
    public List<TruckDto> findAllTruck() {
        return this.vehicleService.getAllTruck()
                .stream().map(vehicleMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/truck")
    public void createTruck(@RequestBody TruckDto truckDto) {
        this.vehicleService.createTruck(this.vehicleMapper.dtoToEntity(truckDto));
    }

    @GetMapping("/trailer")
    public List<TrailerDto> findAllTrailer() {
        return this.vehicleService.getAllTrailer()
                .stream().map(vehicleMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/trailer")
    public void createTrailer(@RequestBody TrailerDto trailerDto) {
        this.vehicleService.createTrailer(this.vehicleMapper.dtoToEntity(trailerDto));
    }
}
