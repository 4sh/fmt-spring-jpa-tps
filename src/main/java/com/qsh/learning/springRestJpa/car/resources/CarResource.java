package com.qsh.learning.springRestJpa.car.resources;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.mappers.CarMapper;
import com.qsh.learning.springRestJpa.car.models.dtos.CarDto;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import com.qsh.learning.springRestJpa.car.services.CarService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
public class CarResource {

    public final CarService carService;

    public final CarMapper carMapper;

    public CarResource(
            CarService carService,
            CarMapper carMapper
    ) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @Operation(
            summary = "Get list of cars",
            description = "Get list of cars, a color parameter can be added to filter by color"
    )
    @GetMapping()
    public List<CarDto> findAll(
            @RequestParam(value = "color", required = false) Color color
    ) {
        List<Car> cars = this.carService.findAll();

        return cars.stream()
                .filter(car -> color == null || color.equals(car.getColor()))
                .map(carMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Operation(
            summary = "Get a car by id",
            description = "Get a car by id"
    )
    @GetMapping("/{id}")
    public CarDto findById(@PathVariable("id") String id) {
        return this.carMapper.entityToDto(this.carService.findById(id));
    }

    @Operation(
            summary = "Create car",
            description = "Create car"
    )
    @PostMapping("")
    public CarDto create(@RequestBody @Valid CarDto car) {
        return this.carMapper.entityToDto(this.carService.create(this.carMapper.dtoToEntity(car)));
    }

    @Operation(
            summary = "Update car",
            description = "Update car"
    )
    @PutMapping("/{id}")
    public CarDto update(
            @PathVariable("id") String id,
            @RequestBody @Valid CarDto car
    ) {
        car.setId(id);
        return this.carMapper.entityToDto(this.carService.update(id, this.carMapper.dtoToEntity(car)));
    }

    @Operation(
            summary = "Delete car by id",
            description = "Delete car by id"
    )
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") String id
    ) {
        this.carService.delete(id);
    }
}
