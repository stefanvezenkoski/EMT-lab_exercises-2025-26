package mk.ukim.finki.emt_lab1.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import mk.ukim.finki.emt_lab1.model.enums.Category;

@Entity
@Table(name = "accommodation_view")
@Immutable
public class AccommodationView {
    @Id
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)  // Додајте ова!
    private Category category;
    private Integer numRooms;
    private String hostFullName;
    private String countryName;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Category getCategory() { return category; }
    public Integer getNumRooms() { return numRooms; }
    public String getHostFullName() { return hostFullName; }
    public String getCountryName() { return countryName; }
}
