package com.qsh.learning.springRestJpa.car.models.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TechnicalControlDto {
    private String id;

    private String garage;

    private String technicalController;

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

    public void setControlYear(String controlYear) {
        this.controlYear = controlYear;
    }
}
