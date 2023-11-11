package com.qsh.learning.springRestJpa.car.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "technical_control")
public class TechnicalControl {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "garage")
    private String garage;

    @Column(name = "technical_controller")
    private String technicalController;

    @Column(name = "control_year")
    private String controlYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getTechnicalController() {
        return technicalController;
    }

    public void setTechnicalController(String technicalController) {
        this.technicalController = technicalController;
    }

    public String getControlYear() {
        return controlYear;
    }

    public void setControlYear(String year) {
        this.controlYear = year;
    }
}
