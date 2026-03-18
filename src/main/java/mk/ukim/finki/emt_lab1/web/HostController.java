package mk.ukim.finki.emt_lab1.web;

import jakarta.validation.Valid;
import mk.ukim.finki.emt_lab1.dto.HostDTO;
import mk.ukim.finki.emt_lab1.model.Host;
import mk.ukim.finki.emt_lab1.service.HostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping
    public ResponseEntity<List<Host>> findAll() {
        return ResponseEntity.ok(hostService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable Long id) {
        return hostService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Host> save(@Valid @RequestBody HostDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hostService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Host> update(@PathVariable Long id,
                                       @Valid @RequestBody HostDTO dto) {
        return ResponseEntity.ok(hostService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hostService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}