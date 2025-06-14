package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GateController {

    private final Random random = new Random();

    @GetMapping("/gate")
    public GateResponse getTemperature(String location) {
        return new GateResponse(location, random.nextBoolean());
    }

    @PostMapping("/gate")
    public void setGate(String location) {
        // get gate from database
        // chage state
    }
}
