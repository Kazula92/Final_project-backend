package com.kodilla.travel_backend.repository;

import com.kodilla.travel_backend.domain.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    @Override
    List<Flight> findAll();

    @Override
    Flight save(Flight flight);

    @Override
    Optional<Flight> findById(Long id);

    @Override
    void deleteById( Long id);
}
