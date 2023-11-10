package com.qsh.learning.springRestJpa.car.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qsh.learning.springRestJpa.car.enums.Color;

public class Car {
    @JsonProperty("id")
    private String id;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("color")
    private Color color;

    @JsonProperty("number_of_doors")
    private Integer numberOfDoors;

    @JsonProperty("number_of_seats")
    private Integer numberOfSeats;

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
}
