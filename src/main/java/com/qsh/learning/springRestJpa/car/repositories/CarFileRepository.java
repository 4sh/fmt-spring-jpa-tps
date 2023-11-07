package com.qsh.learning.springRestJpa.car.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qsh.learning.springRestJpa.car.models.Car;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarFileRepository {

    private final File file;

    private final ObjectMapper objectMapper;

    public CarFileRepository() throws FileNotFoundException {
        this.file = ResourceUtils.getFile("classpath:./data/cars.json");
        this.objectMapper = new ObjectMapper();
    }

    public List<Car> getCars() {
        try {
            return this.objectMapper.readValue(this.file, new TypeReference<List<Car>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Car findById(String id) {
        return this.getCars().stream()
                .filter(car -> Objects.equals(car.getId(), id))
                .findFirst()
                .orElseGet(Car::new);
    }

    public void create(Car car) {
        try {
            List<Car> cars = this.getCars().stream()
                    .filter(c -> !c.getId().equals(car.getId()))
                    .collect(Collectors.toList());
            cars.add(car);
            this.objectMapper.writeValue(this.file, cars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Car car) {
        try {
            List<Car> cars = this.getCars().stream()
                    .map(c -> {
                        if (Objects.equals(car.getId(), c.getId())) {
                            c.setModel(car.getModel());
                            c.setColor(car.getColor());
                            c.setBrand(car.getBrand());
                            c.setNumberOfSeats(car.getNumberOfSeats());
                            c.setNumberOfDoors(car.getNumberOfDoors());
                        }
                        return c;
                    }).collect(Collectors.toList());

            this.objectMapper.writeValue(this.file, cars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
