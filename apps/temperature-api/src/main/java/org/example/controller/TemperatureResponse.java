package org.example.controller;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TemperatureResponse {
    private double value;
    private String unit;
    private LocalDateTime timestamp;
    private String location;
    private String status;
    private String sensor_id;
    private String sensor_type;
    private String description;

    public TemperatureResponse(double value, String unit, LocalDateTime timestamp,
                               String location, String status, String sensor_id,
                               String sensor_type, String description) {
        this.value = value;
        this.unit = unit;
        this.timestamp = timestamp;
        this.location = location;
        this.status = status;
        this.sensor_id = sensor_id;
        this.sensor_type = sensor_type;
        this.description = description;
    }

}