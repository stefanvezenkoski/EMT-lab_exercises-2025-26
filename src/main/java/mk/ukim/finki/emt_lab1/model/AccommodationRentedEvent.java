package mk.ukim.finki.emt_lab1.model;

import mk.ukim.finki.emt_lab1.model.Accommodation;

public class AccommodationRentedEvent {
    private final Accommodation accommodation;

    public AccommodationRentedEvent(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }
}
