package org.example.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class TemperatureResponse {
    private final String location;
    private final String sensorID;
    private final double temperature;
}
