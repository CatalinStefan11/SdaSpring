package ro.sda.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.sda.spring.exception.model.ClientError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class BookAppExceptionHandler {

    @ExceptionHandler(value = BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ClientError handleBookNotFoundEx(BookNotFoundException ex) {
        log.warn("Exception occurred with message: {}", ex.getMessage());
        return new ClientError(LocalDateTime.now(), Collections.singletonList(ex.getMessage()), 404);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ClientError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // Arrays.stream(ex.getDetailMessageArguments()).filter((s) -> !s.toString().isBlank()).map((s) -> s.toString().split(":")[1]).toList()

        List<String> messagesList = Arrays.stream(ex.getDetailMessageArguments())
                .map(Object::toString)
                .filter((s) -> !s.isEmpty())
                .toList();

        List<String> messageToReturnList = new ArrayList<>();

        // "author: Author is required, and gender: Gender is required, and price: Price must be greater than 0, and title: Name is required"
        if (!messagesList.isEmpty()) {

            // 0 -> author: Author is required
            // 1 -> and gender: Gender is required
            // 2 -> and price: Price must be greater than 0
            // 3 -> and title: Name is required
            String[] splitByComma = messagesList.get(0).split(",");

            for (String s : splitByComma) {
                // 0 -> author
                // 1 -> Author is required
                messageToReturnList.add(s.split(":")[1].trim());
            }
        }

        log.warn("Validation failed with message {}", messageToReturnList);
        return new ClientError(LocalDateTime.now(), messageToReturnList, 400);
    }
}
