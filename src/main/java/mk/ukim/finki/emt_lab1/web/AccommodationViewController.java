package mk.ukim.finki.emt_lab1.web;

import mk.ukim.finki.emt_lab1.model.AccommodationView;
import mk.ukim.finki.emt_lab1.repository.AccommodationViewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accommodation-views")
public class AccommodationViewController {
    private final AccommodationViewRepository repository;

    public AccommodationViewController(AccommodationViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<AccommodationView>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
