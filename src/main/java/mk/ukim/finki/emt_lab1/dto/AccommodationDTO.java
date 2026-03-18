package mk.ukim.finki.emt_lab1.dto;
import jakarta.validation.constraints.*;
import mk.ukim.finki.emt_lab1.model.enums.Category;

public record AccommodationDTO (
    @NotBlank(message = "Name is required")
    String name,

    @NotNull(message = "Category is required")
    Category category,

    @NotNull
    @Min(value = 1, message = "Must have at least 1 room")
    Integer numRooms,

    @NotNull(message = "Host is required")
    Long hostId
) {}
