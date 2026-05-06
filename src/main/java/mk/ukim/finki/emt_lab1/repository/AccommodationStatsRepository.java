package mk.ukim.finki.emt_lab1.repository;

import mk.ukim.finki.emt_lab1.model.AccommodationStats;
import mk.ukim.finki.emt_lab1.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationStatsRepository extends JpaRepository<AccommodationStats, Category> {
}
