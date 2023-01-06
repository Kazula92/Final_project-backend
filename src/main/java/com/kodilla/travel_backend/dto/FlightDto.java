package com.kodilla.travel_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

    private Long flightId;
    private String startingPlace;
    private String finalPlace;
    private LocalDate flightDate;
    private LocalTime flightTime;
}
