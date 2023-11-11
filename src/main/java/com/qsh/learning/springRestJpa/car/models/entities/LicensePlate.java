package com.qsh.learning.springRestJpa.car.models.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "license_plate")
public class LicensePlate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "license_plate_number")
    private String licensePlateNumber;

    @Column(name = "country")
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String number) {
        this.licensePlateNumber = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
