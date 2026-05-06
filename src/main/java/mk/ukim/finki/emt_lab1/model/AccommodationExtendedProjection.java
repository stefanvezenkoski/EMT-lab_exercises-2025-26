package mk.ukim.finki.emt_lab1.model;

import mk.ukim.finki.emt_lab1.model.enums.Category;
import org.springframework.beans.factory.annotation.Value;

public interface AccommodationExtendedProjection {
    Long getId();
    String getName();
    Category getCategory();
    Integer getNumRooms();
    String getHostName();
    String getHostSurname();
    String getCountryName();

    @Value("#{target.host.name + ' ' + target.host.surname}")
    String getHostFullName();
}
