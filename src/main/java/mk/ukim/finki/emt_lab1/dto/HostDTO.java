package mk.ukim.finki.emt_lab1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HostDTO (
        @NotBlank String name,
        @NotBlank String surname,
        @NotNull Long countryId
) {}
