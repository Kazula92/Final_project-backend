package com.kodilla.travel_backend.service;

import com.kodilla.travel_backend.domain.Flight;
import com.kodilla.travel_backend.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlight(final Long id) {
        return flightRepository.findById(id);
    }

    public Flight save(final Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(final Long id) {
        flightRepository.deleteById(id);
    }
}
