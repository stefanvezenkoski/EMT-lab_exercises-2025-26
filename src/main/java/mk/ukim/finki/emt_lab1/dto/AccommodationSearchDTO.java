package mk.ukim.finki.emt_lab1.dto;

import mk.ukim.finki.emt_lab1.model.enums.Category;

public record AccommodationSearchDTO(
        Long id,
        String name,
        Category category,
        Integer numRooms,
        Boolean rented,
        String hostName,
        String countryName
) {}
