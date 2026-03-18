package mk.ukim.finki.emt_lab1.dto;

import jakarta.validation.constraints.NotBlank;

public record CountryDTO(

        @NotBlank(message = "Name must not be blank")
        String name,

        @NotBlank(message = "Continent must not be blank")
        String continent
) {}