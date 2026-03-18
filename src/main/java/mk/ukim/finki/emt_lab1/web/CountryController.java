package mk.ukim.finki.emt_lab1.web;

import jakarta.validation.Valid;
import mk.ukim.finki.emt_lab1.dto.CountryDTO;
import mk.ukim.finki.emt_lab1.model.Country;
import mk.ukim.finki.emt_lab1.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return countryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Country> save(@Valid @RequestBody CountryDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(countryService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id,
                                          @Valid @RequestBody CountryDTO dto) {
        return ResponseEntity.ok(countryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        countryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
