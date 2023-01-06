package com.kodilla.travel_backend.controller;


import com.kodilla.travel_backend.dto.AccommodationDto;
import com.kodilla.travel_backend.mapper.AccommodationMapper;
import com.kodilla.travel_backend.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accommodation")
@RequiredArgsConstructor
public class AccommodationController {

    private final AccommodationMapper accommodationMapper;
    private final AccommodationService accommodationService;

    @GetMapping(value= "/getAccommodations")
    public List<AccommodationDto> getAccommodation() {
        return accommodationMapper.mapToAccommodationDtoList(accommodationService.getAllAccommodation());
    }

    @PutMapping(value= "/addAccommodation")
    public void addAccommodation(@RequestBody AccommodationDto accommodationDto) {
        accommodationService.save(accommodationMapper.mapToAccommodation(accommodationDto));
    }

    @GetMapping(value= "getAccommodation")
    public AccommodationDto accommodationDto(@RequestParam Long accomodationId) throws AccommodationWithoutException {
        return accommodationMapper.mapToAccommodationDto(accommodationService.getAccommodation(accomodationId)
                .orElseThrow(AccommodationWithoutException::new));
    }

    @DeleteMapping(value= "deleteAccommodation")
    public void delAccommodation(@RequestParam Long accommodationId) {
        accommodationService.deleteAccommodation(accommodationId);
    }
}
