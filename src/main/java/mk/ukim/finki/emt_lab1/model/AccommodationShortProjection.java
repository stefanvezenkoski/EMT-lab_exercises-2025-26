package mk.ukim.finki.emt_lab1.model;

import mk.ukim.finki.emt_lab1.model.enums.Category;

public interface AccommodationShortProjection {
    Long getId();
    String getName();
    Category getCategory();
    Integer getNumRooms();
}
