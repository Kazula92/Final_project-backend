package com.kodilla.travel_backend.service;

import com.kodilla.travel_backend.domain.Accommodation;
import com.kodilla.travel_backend.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    public List<Accommodation> getAllAccommodation() {
        return accommodationRepository.findAll();
    }

    public Optional<Accommodation> getAccommodation(final Long id) {
        return accommodationRepository.findById(id);
    }

    public Accommodation save (final Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    public void deleteAccommodation(final Long id) {
        accommodationRepository.deleteById(id);
    }
}
