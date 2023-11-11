package com.qsh.learning.springRestJpa.car.models.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.qsh.learning.springRestJpa.car.enums.Color;
import com.qsh.learning.springRestJpa.car.validation.ReferenceConstraint;
import jakarta.validation.constraints.*;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CarDto {
    private String id;

    @NotBlank
    private String brand;

    @NotBlank
    @Size(max = 20)
    private String model;

    private Color color;

    @Min(1)
    @Max(5)
    private Integer numberOfDoors;

    @Min(1)
    @Max(5)
    private Integer numberOfSeats;

    @ReferenceConstraint
    private String catalogReference;

    private LicensePlateDto licensePlate;

    private List<TechnicalControlDto> technicalControls;

    private List<DriverDto> drivers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getCatalogReference() {
        return catalogReference;
    }

    public void setCatalogReference(String catalogReference) {
        this.catalogReference = catalogReference;
    }

    public LicensePlateDto getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlateDto licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<TechnicalControlDto> getTechnicalControls() {
        return technicalControls;
    }

    public void setTechnicalControls(List<TechnicalControlDto> technicalControls) {
        this.technicalControls = technicalControls;
    }

    public List<DriverDto> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDto> drivers) {
        this.drivers = drivers;
    }
}
