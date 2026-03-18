package mk.ukim.finki.emt_lab1.exception;

public class AccommodationNotDeletableException extends RuntimeException {
    public AccommodationNotDeletableException(Long id) {
        super("Accommodation with id " + id + " cannot be deleted because it is not in BAD condition");
    }
}