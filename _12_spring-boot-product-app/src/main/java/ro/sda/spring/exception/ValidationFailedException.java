package ro.sda.spring.exception;

public class ValidationFailedException extends RuntimeException {
    public ValidationFailedException(String message) {
        super(message);
    }
}
