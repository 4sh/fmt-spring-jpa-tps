package com.qsh.learning.springRestJpa.vehicle.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TRAILER")
public class Trailer extends Vehicle {
    @Column(name = "registration")
    private String registration;

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String test) {
        this.registration = test;
    }
}
