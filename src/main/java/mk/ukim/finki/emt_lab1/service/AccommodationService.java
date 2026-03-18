package mk.ukim.finki.emt_lab1.service;

import mk.ukim.finki.emt_lab1.dto.AccommodationDTO;
import mk.ukim.finki.emt_lab1.model.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Accommodation save(AccommodationDTO dto);
    Accommodation update(Long id, AccommodationDTO dto);
    void deleteById(Long id);
    Accommodation markAsRented(Long id);
}