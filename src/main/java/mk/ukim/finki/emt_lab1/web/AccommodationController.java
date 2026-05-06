package mk.ukim.finki.emt_lab1.web;

import jakarta.validation.Valid;
import mk.ukim.finki.emt_lab1.dto.AccommodationDTO;
import mk.ukim.finki.emt_lab1.dto.AccommodationSearchDTO;
import mk.ukim.finki.emt_lab1.model.Accommodation;
import mk.ukim.finki.emt_lab1.model.AccommodationExtendedProjection;
import mk.ukim.finki.emt_lab1.model.AccommodationShortProjection;
import mk.ukim.finki.emt_lab1.model.enums.Category;
import mk.ukim.finki.emt_lab1.service.AccommodationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public ResponseEntity<List<Accommodation>> findAll() {
        return ResponseEntity.ok(accommodationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id) {
        return accommodationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Accommodation> save(@Valid @RequestBody AccommodationDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(accommodationService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id,
                                                @Valid @RequestBody AccommodationDTO dto) {
        return ResponseEntity.ok(accommodationService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accommodationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/rent")
    public ResponseEntity<Accommodation> markAsRented(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationService.markAsRented(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<AccommodationSearchDTO>> searchAccommodations(
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) Long hostId,
            @RequestParam(required = false) Long countryId,
            @RequestParam(required = false) Integer minRooms,
            @RequestParam(required = false) Boolean available,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name,asc") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort.split(",")));
        return ResponseEntity.ok(accommodationService.searchAccommodations(category, hostId, countryId, minRooms, available, pageable));
    }

    @GetMapping("/with-relations")
    public ResponseEntity<List<Accommodation>> findAllWithRelations() {
        return ResponseEntity.ok(accommodationService.findAllWithHostAndCountry());
    }

    @GetMapping("/short")
    public ResponseEntity<List<AccommodationShortProjection>> findAllShort() {
        return ResponseEntity.ok(accommodationService.findAllShort());
    }

    @GetMapping("/extended")
    public ResponseEntity<List<AccommodationExtendedProjection>> findAllExtended() {
        return ResponseEntity.ok(accommodationService.findAllExtended());
    }

}
