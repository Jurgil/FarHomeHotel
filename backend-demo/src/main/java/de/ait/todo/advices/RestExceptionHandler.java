package de.ait.todo.advices;

import de.ait.todo.dto.StandardResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import de.ait.todo.exceptions.NotFoundException;
/**
 * 6/15/2023
 * spring-security-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponseDto> handleNotFound(NotFoundException ex) {
        log.error(ex.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(StandardResponseDto.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .build());
    }
}
