package mk.ukim.finki.emt_lab1.service.impl;

import mk.ukim.finki.emt_lab1.dto.CountryDTO;
import mk.ukim.finki.emt_lab1.exception.CountryNotFoundException;
import mk.ukim.finki.emt_lab1.model.Country;
import mk.ukim.finki.emt_lab1.repository.CountryRepository;
import mk.ukim.finki.emt_lab1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(CountryDTO dto) {
        Country country = new Country();
        country.setName(dto.name());
        country.setContinent(dto.continent());
        return countryRepository.save(country);
    }

    @Override
    public Country update(Long id, CountryDTO dto) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
        country.setName(dto.name());
        country.setContinent(dto.continent());
        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        if (!countryRepository.existsById(id)) {
            throw new CountryNotFoundException(id);
        }
        countryRepository.deleteById(id);
    }
}