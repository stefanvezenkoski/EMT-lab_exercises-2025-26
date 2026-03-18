package mk.ukim.finki.emt_lab1.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {
        super("Country with id " + id + " was not found");
    }
}