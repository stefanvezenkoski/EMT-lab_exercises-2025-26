package mk.ukim.finki.emt_lab1.exception;

public class AccommodationNotFoundException extends RuntimeException {
    public AccommodationNotFoundException(Long id) {
        super("Accommodation with id " + id + " was not found");
    }
}