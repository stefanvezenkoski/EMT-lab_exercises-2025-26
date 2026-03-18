package mk.ukim.finki.emt_lab1.service.impl;

import mk.ukim.finki.emt_lab1.dto.AccommodationDTO;
import mk.ukim.finki.emt_lab1.exception.AccommodationNotDeletableException;
import mk.ukim.finki.emt_lab1.exception.AccommodationNotDeletableException;
import mk.ukim.finki.emt_lab1.exception.HostNotFoundException;
import mk.ukim.finki.emt_lab1.model.Accommodation;
import mk.ukim.finki.emt_lab1.model.Host;
import mk.ukim.finki.emt_lab1.model.enums.Condition;
import mk.ukim.finki.emt_lab1.repository.AccommodationRepository;
import mk.ukim.finki.emt_lab1.repository.HostRepository;
import mk.ukim.finki.emt_lab1.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository,
                                    HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Accommodation save(AccommodationDTO dto) {
        Host host = hostRepository.findById(dto.hostId())
                .orElseThrow(() -> new HostNotFoundException(dto.hostId()));

        Accommodation accommodation = new Accommodation();
        accommodation.setName(dto.name());
        accommodation.setCategory(dto.category());
        accommodation.setNumRooms(dto.numRooms());
        accommodation.setHost(host);
        // condition и rented се setираат во @PrePersist
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation update(Long id, AccommodationDTO dto) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotDeletableException(id));
        Host host = hostRepository.findById(dto.hostId())
                .orElseThrow(() -> new HostNotFoundException(dto.hostId()));

        accommodation.setName(dto.name());
        accommodation.setCategory(dto.category());
        accommodation.setNumRooms(dto.numRooms());
        accommodation.setHost(host);
        return accommodationRepository.save(accommodation);
    }

    @Override
    public void deleteById(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotDeletableException(id));
        if (accommodation.getCondition() == Condition.BAD) {
            accommodationRepository.deleteById(id);
        } else {
            throw new AccommodationNotDeletableException(id);
        }
    }

    @Override
    public Accommodation markAsRented(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotDeletableException(id));
        accommodation.setRented(true);
        return accommodationRepository.save(accommodation);
    }
}