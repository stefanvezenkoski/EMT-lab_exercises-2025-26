package mk.ukim.finki.emt_lab1.service;

import mk.ukim.finki.emt_lab1.dto.CountryDTO;
import mk.ukim.finki.emt_lab1.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(CountryDTO dto);
    Country update(Long id, CountryDTO dto);
    void deleteById(Long id);
}