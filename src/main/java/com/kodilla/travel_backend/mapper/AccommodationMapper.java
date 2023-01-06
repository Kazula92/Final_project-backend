package com.kodilla.travel_backend.mapper;

import com.kodilla.travel_backend.domain.Accommodation;
import com.kodilla.travel_backend.dto.AccommodationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccommodationMapper {

    public Accommodation mapToAccommodation(final AccommodationDto accommodationDto) {
        return new Accommodation(
                accommodationDto.getAccommodationId(),
                accommodationDto.getName(),
                accommodationDto.getLocation(),
                accommodationDto.getPrice(),
                accommodationDto.isAvailability()
        );
    }

    public AccommodationDto mapToAccommodationDto( final Accommodation accommodation) {
        return new AccommodationDto(
                accommodation.getAId(),
                accommodation.getName(),
                accommodation.getLocation(),
                accommodation.getPrice(),
                accommodation.getAccommodationDate(),
                accommodation.getNumberOfPeople(),
                accommodation.isAvailability()
        );
    }

    public List<AccommodationDto> mapToAccommodationDtoList(final List<Accommodation> accommodationList) {
        return accommodationList.stream()
                .map(s-> mapToAccommodationDto(s))
                .collect(Collectors.toList());
    }
}
