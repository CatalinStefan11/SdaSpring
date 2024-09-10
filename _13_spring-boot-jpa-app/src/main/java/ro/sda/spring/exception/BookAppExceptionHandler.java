package ro.sda.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.sda.spring.exception.model.ClientError;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class BookAppExceptionHandler {

    @ExceptionHandler(value = BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ClientError handleBookNotFoundEx(BookNotFoundException ex) {
        log.warn("Exception occurred with message: {}", ex.getMessage());
        return new ClientError(LocalDateTime.now(), ex.getMessage(), 404);
    }
}
