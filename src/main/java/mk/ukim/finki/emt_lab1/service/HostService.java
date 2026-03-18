package mk.ukim.finki.emt_lab1.service;
import mk.ukim.finki.emt_lab1.dto.HostDTO;
import mk.ukim.finki.emt_lab1.model.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);
    Host save(HostDTO dto);
    Host update(Long id, HostDTO dto);
    void deleteById(Long id);
}
