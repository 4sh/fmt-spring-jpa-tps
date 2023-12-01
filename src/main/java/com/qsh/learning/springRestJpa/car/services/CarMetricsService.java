package com.qsh.learning.springRestJpa.car.services;

import com.qsh.learning.springRestJpa.car.models.dtos.CarMetricsDto;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class CarMetricsService {

    private final Counter carFindCounter;

    public CarMetricsService(  MeterRegistry meterRegistry) {
        this.carFindCounter = meterRegistry.counter("car.find");
    }

    public void incrementFindCounter() {
        carFindCounter.increment();
    }

    public CarMetricsDto getFindMetrics() {
        CarMetricsDto carMetricsDto = new CarMetricsDto();
        carMetricsDto.setCount((int)carFindCounter.count());

        return carMetricsDto;
    }
}
