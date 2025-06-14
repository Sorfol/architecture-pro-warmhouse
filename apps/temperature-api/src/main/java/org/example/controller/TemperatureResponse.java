package org.example.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TemperatureResponse {
    @JsonProperty
    private double value;
    @JsonProperty
    private String unit;
    private LocalDateTime timestamp;
    @JsonProperty
    private String location;
    @JsonProperty
    private String status;
    @JsonProperty("sensor_id")
    private String sensorId;
    @JsonProperty("sensor_type")
    private String sensorType;
    @JsonProperty
    private String description;

    // Конструктор
    public TemperatureResponse(double value, String unit, LocalDateTime timestamp,
                               String location, String status, String sensorId,
                               String sensorType, String description) {
        this.value = value;
        this.unit = unit;
        this.timestamp = timestamp;
        this.location = location;
        this.status = status;
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.description = description;
    }

}