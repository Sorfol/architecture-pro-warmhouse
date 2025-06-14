package org.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
public class TemperatureController {
    private final Random random = new Random();

    @GetMapping("/temperature")
    public TemperatureResponse getTemperatureByLocation(
            @RequestParam(required = false) String location) {

        String sensorID = determineSensorIdByLocation(location);
        double temperature = generateTemperature();
        return buildResponse(location, sensorID, temperature);
    }

    @GetMapping(value = "/temperature/{sensorID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TemperatureResponse getTemperatureBySensorId(
            @PathVariable String sensorID,
            @RequestParam(required = false) String location) {

        if (location == null) {
            location = determineLocationBySensorId(sensorID);
        }
        double temperature = generateTemperature();
        return buildResponse(location, sensorID, temperature);
    }

    private double generateTemperature() {
        return (60 * random.nextDouble()) - 20;
    }

    private TemperatureResponse buildResponse(String location, String sensorID, double temperature) {
        return new TemperatureResponse(
                temperature,
                "C",
                LocalDateTime.now(),
                location != null ? location : "Unknown",
                "OK",
                sensorID != null ? sensorID : "0",
                "digital",
                "Current temperature"
        );
    }

    private String determineLocationBySensorId(String sensorID) {
        if (sensorID == null) return "Unknown";
        return switch (sensorID) {
            case "1" -> "Living Room";
            case "2" -> "Bedroom";
            case "3" -> "Kitchen";
            default -> "Unknown";
        };
    }

    private String determineSensorIdByLocation(String location) {
        if (location == null) return "0";
        return switch (location) {
            case "Living Room" -> "1";
            case "Bedroom" -> "2";
            case "Kitchen" -> "3";
            default -> "0";
        };
    }
}