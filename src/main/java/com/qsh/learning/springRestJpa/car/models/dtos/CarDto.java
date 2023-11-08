package com.qsh.learning.springRestJpa.car.models.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.qsh.learning.springRestJpa.car.validation.ReferenceConstraint;
import jakarta.validation.constraints.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CarDto {
    @NotBlank
    private String id;

    @NotBlank
    private String brand;

    @NotBlank
    @Size(max = 20)
    private String model;

    private String color;

    @Min(1)
    @Max(5)
    private Integer numberOfDoors;

    @Min(1)
    @Max(5)
    private Integer numberOfSeats;

    @ReferenceConstraint
    private String catalogReference;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
}
