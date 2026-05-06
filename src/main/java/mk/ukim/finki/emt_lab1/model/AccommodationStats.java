package mk.ukim.finki.emt_lab1.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import mk.ukim.finki.emt_lab1.model.enums.Category;
import java.math.BigDecimal;  // Додајте импорт

@Entity
@Table(name = "accommodation_stats")
@Immutable
public class AccommodationStats {
    @Id
    @Enumerated(EnumType.STRING)
    private Category category;
    private Long totalAccommodations;
    private Integer totalRooms;
    private BigDecimal avgRooms;  // Променете од Double на BigDecimal

    // Getters
    public Category getCategory() { return category; }
    public Long getTotalAccommodations() { return totalAccommodations; }
    public Integer getTotalRooms() { return totalRooms; }
    public BigDecimal getAvgRooms() { return avgRooms; }  // Променете return тип
}
