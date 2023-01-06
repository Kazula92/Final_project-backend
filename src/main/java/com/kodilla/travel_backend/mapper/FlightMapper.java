package com.kodilla.travel_backend.mapper;

import com.kodilla.travel_backend.domain.Flight;
import com.kodilla.travel_backend.dto.FlightDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {

    public Flight mapToFlight(final FlightDto flightDto) {
        return new Flight(
                flightDto.getFlightId(),
                flightDto.getFinalPlace(),
                flightDto.getFlightDate(),
                flightDto.getFlightTime()
        );
    }
    public FlightDto mapToFlightDto(final Flight flight) {
        return new FlightDto(
                flight.getFlightId(),
                flight.getStartingPlace(),
                flight.getFinalPlace(),
                flight.getFlightDate(),
                flight.getFlightTime()
        );
    }
    public List<FlightDto> mapToFlightDtoList(final List<Flight> flightList) {
        return flightList.stream()
                .map(s-> mapToFlightDto(s))
                .collect(Collectors.toList());
    }
}
