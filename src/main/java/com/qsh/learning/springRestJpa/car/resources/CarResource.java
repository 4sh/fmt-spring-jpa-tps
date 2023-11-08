package com.qsh.learning.springRestJpa.car.resources;

import com.qsh.learning.springRestJpa.car.mappers.CarMapper;
import com.qsh.learning.springRestJpa.car.models.dtos.CarDto;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import com.qsh.learning.springRestJpa.car.services.CarService;
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

    @GetMapping()
    public List<CarDto> findAll(
            @RequestParam(value = "color", required = false) String color
    ) {
        List<Car> cars = this.carService.findAll();

        return cars.stream()
                .filter(car -> color == null || color.equals(car.getColor()))
                .map(carMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CarDto findById(@PathVariable("id") String id) {
        return this.carMapper.entityToDto(this.carService.findById(id));
    }

    @PostMapping("")
    public CarDto create(@RequestBody CarDto car) {
        return this.carMapper.entityToDto(this.carService.create(this.carMapper.dtoToEntity(car)));
    }

    @PutMapping("/{id}")
    public CarDto update(
            @PathVariable("id") String id,
            @RequestBody CarDto car
    ) {
        car.setId(id);
        return this.carMapper.entityToDto(this.carService.update(id, this.carMapper.dtoToEntity(car)));
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") String id
    ) {
        this.carService.delete(id);
    }
}
