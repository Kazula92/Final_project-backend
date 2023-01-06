package com.kodilla.travel_backend.controller;

import com.kodilla.travel_backend.dto.WeatherDto;
import com.kodilla.travel_backend.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping(value = "/getWeather")
    public void getWeather() {
        List<WeatherDto> weather = weatherService.getWeather();
        weather.forEach(weatherDto -> System.out.println(weatherDto.getNameCity() + weatherDto.getTemperature()));
    }
}
