package com.kodilla.travel_backend.controller;

import com.kodilla.travel_backend.domain.Flight;
import com.kodilla.travel_backend.dto.FlightDto;
import com.kodilla.travel_backend.mapper.FlightMapper;
import com.kodilla.travel_backend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightMapper flightMapper;
    private final FlightService flightService;

    @GetMapping(value= "/getFlights")
    public List<FlightDto> getFlight() {
        return flightMapper.mapToFlightDtoList(flightService.getAllFlight());
    }

    @PutMapping(value= "/addFlight")
    public void addFlight(@RequestBody FlightDto flightDto) {
        flightService.save(flightMapper.mapToFlight(flightDto));
    }

    @GetMapping(value="/getFlight")
    public FlightDto flightDto(@RequestParam Long flightId) throws FlightWithoutException {
        return flightMapper.mapToFlightDto(flightService.getFlight(flightId).orElseThrow(FlightWithoutException::new));
    }

    @DeleteMapping(value="/deleteFlight")
    public void delFlight(@RequestParam Long flightId) {
        flightService.deleteFlight(flightId);
    }
}
