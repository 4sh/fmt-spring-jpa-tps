package com.qsh.learning.springRestJpa.car.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Embedded
    private CarDescription carDescription;

    @Column(name = "number_of_doors")
    private Integer numberOfDoors;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "license_plate_id")
    private LicensePlate licensePlate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarDescription getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(CarDescription carDescription) {
        this.carDescription = carDescription;
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

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }
}
