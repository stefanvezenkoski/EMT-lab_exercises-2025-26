package mk.ukim.finki.emt_lab1.repository;

import mk.ukim.finki.emt_lab1.model.Accommodation;
import mk.ukim.finki.emt_lab1.model.AccommodationExtendedProjection;
import mk.ukim.finki.emt_lab1.model.AccommodationShortProjection;
import mk.ukim.finki.emt_lab1.model.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    Page<Accommodation> findByCategoryAndHost_Country_NameAndNumRoomsGreaterThanAndRented(
            Category category, String countryName, Integer minRooms, Boolean rented, Pageable pageable);

    @Query("SELECT a FROM Accommodation a WHERE " +
            "(:category IS NULL OR a.category = :category) AND " +
            "(:hostId IS NULL OR a.host.id = :hostId) AND " +
            "(:countryId IS NULL OR a.host.country.id = :countryId) AND " +
            "(:minRooms IS NULL OR a.numRooms >= :minRooms) AND " +
            "(:available IS NULL OR (a.rented = false AND a.numRooms > 0))")
    Page<Accommodation> searchAccommodations(
            @Param("category") Category category,
            @Param("hostId") Long hostId,
            @Param("countryId") Long countryId,
            @Param("minRooms") Integer minRooms,
            @Param("available") Boolean available,
            Pageable pageable);

    @EntityGraph(attributePaths = {"host", "host.country"})
    Optional<Accommodation> findWithHostAndCountryById(Long id);

    @Query("SELECT a FROM Accommodation a JOIN FETCH a.host h JOIN FETCH h.country")
    List<Accommodation> findAllWithHostAndCountry();

    List<AccommodationShortProjection> findAllShort();

    List<AccommodationExtendedProjection> findAllExtended();

}
