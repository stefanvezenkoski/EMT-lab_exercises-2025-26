package mk.ukim.finki.emt_lab1.service;

import mk.ukim.finki.emt_lab1.dto.AccommodationDTO;
import mk.ukim.finki.emt_lab1.dto.AccommodationSearchDTO;
import mk.ukim.finki.emt_lab1.model.Accommodation;
import mk.ukim.finki.emt_lab1.model.AccommodationExtendedProjection;
import mk.ukim.finki.emt_lab1.model.AccommodationShortProjection;
import mk.ukim.finki.emt_lab1.model.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Accommodation save(AccommodationDTO dto);
    Accommodation update(Long id, AccommodationDTO dto);
    void deleteById(Long id);
    Accommodation markAsRented(Long id);
    Page<AccommodationSearchDTO> searchAccommodations(Category category, Long hostId, Long countryId, Integer minRooms, Boolean available, Pageable pageable);
    Optional<Accommodation> findWithHostAndCountryById(Long id);
    List<Accommodation> findAllWithHostAndCountry();
    List<AccommodationShortProjection> findAllShort();
    List<AccommodationExtendedProjection> findAllExtended();

}
