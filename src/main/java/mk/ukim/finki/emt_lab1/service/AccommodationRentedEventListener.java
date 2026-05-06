package mk.ukim.finki.emt_lab1.service;

import mk.ukim.finki.emt_lab1.model.AccommodationRentedEvent;
import mk.ukim.finki.emt_lab1.model.ActivityLog;
import mk.ukim.finki.emt_lab1.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AccommodationRentedEventListener {
    @Autowired
    private ActivityLogRepository activityLogRepository;

    @EventListener
    public void handleAccommodationRented(AccommodationRentedEvent event) {
        // Лог
        System.out.println("Accommodation rented: " + event.getAccommodation().getName());
        // Запиши во табела
        ActivityLog log = new ActivityLog();
        log.setAccommodationName(event.getAccommodation().getName());
        log.setEventTime(LocalDateTime.now());
        log.setEventType("RENTED");
        activityLogRepository.save(log);

        // Проверка за fully booked
        if (event.getAccommodation().getNumRooms() == 0) {
            System.out.println("Accommodation fully booked: " + event.getAccommodation().getName());
        }
    }
}
