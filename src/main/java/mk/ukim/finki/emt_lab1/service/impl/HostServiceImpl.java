package mk.ukim.finki.emt_lab1.service.impl;

import mk.ukim.finki.emt_lab1.dto.HostDTO;
import mk.ukim.finki.emt_lab1.exception.CountryNotFoundException;
import mk.ukim.finki.emt_lab1.exception.HostNotFoundException;
import mk.ukim.finki.emt_lab1.model.Country;
import mk.ukim.finki.emt_lab1.model.Host;
import mk.ukim.finki.emt_lab1.repository.CountryRepository;
import mk.ukim.finki.emt_lab1.repository.HostRepository;
import mk.ukim.finki.emt_lab1.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Host save(HostDTO dto) {
        Country country = countryRepository.findById(dto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(dto.countryId()));
        Host host = new Host();
        host.setName(dto.name());
        host.setSurname(dto.surname());
        host.setCountry(country);
        return hostRepository.save(host);
    }

    @Override
    public Host update(Long id, HostDTO dto) {
        Host host = hostRepository.findById(id)
                .orElseThrow(() -> new HostNotFoundException(id));
        Country country = countryRepository.findById(dto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(dto.countryId()));
        host.setName(dto.name());
        host.setSurname(dto.surname());
        host.setCountry(country);
        return hostRepository.save(host);
    }

    @Override
    public void deleteById(Long id) {
        if (!hostRepository.existsById(id)) {
            throw new HostNotFoundException(id);
        }
        hostRepository.deleteById(id);
    }
}