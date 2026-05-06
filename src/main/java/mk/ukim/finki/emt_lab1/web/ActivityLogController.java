package mk.ukim.finki.emt_lab1.web;

import mk.ukim.finki.emt_lab1.model.ActivityLog;
import mk.ukim.finki.emt_lab1.repository.ActivityLogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
public class ActivityLogController {
    private final ActivityLogRepository repository;

    public ActivityLogController(ActivityLogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Page<ActivityLog>> findAll(Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable));
    }
}
