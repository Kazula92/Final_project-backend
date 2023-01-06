package com.kodilla.travel_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationDto {

    private Long accommodationId;
    private String name;
    private String location;
    private double price;
    private LocalDate accommodationDate;
    private int numberOfPeople;
    private boolean availability;
}
