package org.example.controller;

public record TemperatureResponse(String location, String sensorID, double temperature) {
}
