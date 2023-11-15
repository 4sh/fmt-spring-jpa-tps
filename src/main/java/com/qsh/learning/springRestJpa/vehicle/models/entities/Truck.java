package com.qsh.learning.springRestJpa.vehicle.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "truck")
@DiscriminatorValue("TRUCK")
public class Truck extends Vehicle {
    @Column(name = "tonnage")
    private Integer tonnage;

    public Integer getTonnage() {
        return tonnage;
    }

    public void setTonnage(Integer tonnage) {
        this.tonnage = tonnage;
    }
}
