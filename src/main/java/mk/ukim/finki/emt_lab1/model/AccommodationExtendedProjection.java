package mk.ukim.finki.emt_lab1.model;

import mk.ukim.finki.emt_lab1.model.enums.Category;
import org.springframework.beans.factory.annotation.Value;

public interface AccommodationExtendedProjection {
    Long getId();
    String getName();
    Category getCategory();
    Integer getNumRooms();

    @Value("#{target.host.name}")
    String getHostName();

    @Value("#{target.host.surname}")
    String getHostSurname();

    @Value("#{target.host.country.name}")
    String getCountryName();

    @Value("#{target.host.name + ' ' + target.host.surname}")
    String getHostFullName();
}