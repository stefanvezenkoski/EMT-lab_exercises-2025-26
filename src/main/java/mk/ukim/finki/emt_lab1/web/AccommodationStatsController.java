package mk.ukim.finki.emt_lab1.web;

import mk.ukim.finki.emt_lab1.model.AccommodationStats;
import mk.ukim.finki.emt_lab1.repository.AccommodationStatsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accommodation-stats")
public class AccommodationStatsController {
    private final AccommodationStatsRepository repository;

    public AccommodationStatsController(AccommodationStatsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<AccommodationStats>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
