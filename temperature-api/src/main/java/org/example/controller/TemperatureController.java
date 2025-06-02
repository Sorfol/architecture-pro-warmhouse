package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TemperatureController {

    private final Random random = new Random();

    @GetMapping("/temperature")
    public TemperatureResponse getTemperature(@RequestParam(required = false) String location, String sensorID) {
        double temperature = (60 * random.nextDouble()) - 20;

        if (location == null || sensorID == null) {
            location = "Unknown";
            sensorID = "0";
        }
        else {
            if (location.isEmpty()) {
                switch (sensorID) {
                    case "1":
                        location = "Living Room";
                    case "2":
                        location = "Bedroom";
                    case "3":
                        location = "Kitchen";
                    default:
                        location = "Unknown";
                }
            }

            if (sensorID.isEmpty()) {
                switch (location) {
                    case "Living Room":
                        sensorID = "1";
                    case "Bedroom":
                        sensorID = "2";
                    case "Kitchen":
                        sensorID = "3";
                    default:
                        sensorID = "0";
                }
            }
        }
        return new TemperatureResponse(location, sensorID, Math.round(temperature * 10) / 10.0);
    }
}
