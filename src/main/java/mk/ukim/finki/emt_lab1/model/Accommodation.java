package mk.ukim.finki.emt_lab1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.emt_lab1.model.enums.Category;
import mk.ukim.finki.emt_lab1.model.enums.Condition;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "accommodation")
@Data
@NoArgsConstructor
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Condition condition;

    private Integer numRooms;

    @ManyToOne
    private Host host;

    private boolean rented;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.condition = Condition.GOOD;
        this.rented = false;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
