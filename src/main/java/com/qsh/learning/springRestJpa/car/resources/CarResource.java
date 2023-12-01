package com.qsh.learning.springRestJpa.car.resources;

import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.mappers.CarMapper;
import com.qsh.learning.springRestJpa.car.mappers.LicensePlateMapper;
import com.qsh.learning.springRestJpa.car.models.dtos.CarDto;
import com.qsh.learning.springRestJpa.car.models.dtos.CarMetricsDto;
import com.qsh.learning.springRestJpa.car.models.dtos.CarSummaryDto;
import com.qsh.learning.springRestJpa.car.models.dtos.LicensePlateDto;
import com.qsh.learning.springRestJpa.car.models.entities.Car;
import com.qsh.learning.springRestJpa.car.services.CarMetricsService;
import com.qsh.learning.springRestJpa.car.services.CarService;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
public class CarResource {

    public final CarService carService;

    public final CarMapper carMapper;

    public final LicensePlateMapper licensePlateMapper;

    public final CarMetricsService carMetricsService;

    public CarResource(
            CarService carService,
            CarMapper carMapper,
            LicensePlateMapper licensePlateMapper,
            CarMetricsService carMetricsService
    ) {
        this.carService = carService;
        this.carMapper = carMapper;
        this.licensePlateMapper = licensePlateMapper;
        this.carMetricsService = carMetricsService;
    }

    @Operation(
            summary = "Get list of cars",
            description = "Get list of cars, a color parameter can be added to filter by color"
    )
    @GetMapping()
    public List<CarDto> findAll(
            @RequestParam(value = "color", required = false) Color color
    ) {
        List<Car> cars = this.carService.findAll(color);

        return cars.stream()
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

    @Operation(
            summary = "Get license plate",
            description = "Get all license plate assigned to a car with a specific color"
    )
    @GetMapping("/with-color/{color}/licensePlate")
    public List<LicensePlateDto> getLicensePlates(
            @PathVariable("color") Color color
    ) {
        return this.carService.getLicensePlates(color).stream()
                .map(this.licensePlateMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Operation(
            summary = "Get car summaries",
            description = "Get car summaries with brand and number of seats"
    )
    @GetMapping("/summary")
    public List<CarSummaryDto> getCarSummaries() {
        return this.carService.getCarSummaries().stream()
                .map(this.carMapper::summaryEntityToSummaryDto)
                .collect(Collectors.toList());
    }

    @Operation(
            summary = "Get metrics on find request",
            description = "Get metrics on find request"
    )
    @GetMapping("/metrics/find")
    public CarMetricsDto getMetrics() {
        return carMetricsService.getFindMetrics();
    }
}
