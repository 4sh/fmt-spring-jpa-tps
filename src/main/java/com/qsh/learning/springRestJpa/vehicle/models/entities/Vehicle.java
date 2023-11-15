package com.qsh.learning.springRestJpa.vehicle.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        name = "vehicle_class",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "brand")
    private String brand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
