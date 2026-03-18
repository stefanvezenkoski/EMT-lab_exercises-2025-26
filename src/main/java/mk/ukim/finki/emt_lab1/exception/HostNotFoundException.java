package mk.ukim.finki.emt_lab1.exception;

public class HostNotFoundException extends RuntimeException {
    public HostNotFoundException(Long id) {
        super("Host with id " + id + " was not found");
    }
}