package org.example.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class TemperatureController {
    private final Random random = new Random();

    @GetMapping("/temperature")
    public double getTemperatureByLocation(
            @RequestParam(required = false) String location) {

        String sensorID = determineSensorIdByLocation(location);
        double temperature = generateTemperature();
        return generateTemperature();
    }

    @GetMapping("/temperature/{sensorID}")
    public double getTemperatureBySensorId(
            @PathVariable String sensorID,
            @RequestParam(required = false) String location) {

        if (location == null) {
            location = determineLocationBySensorId(sensorID);
        }
        return generateTemperature();
    }

    private double generateTemperature() {
        return (60 * random.nextDouble()) - 20;
    }

    private TemperatureResponse buildResponse(String location, String sensorID, double temperature) {
        return new TemperatureResponse(
                location != null ? location : "Unknown",
                sensorID != null ? sensorID : "0",
                Math.round(temperature * 10) / 10.0
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