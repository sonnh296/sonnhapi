package dev.sonnhapi.exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidRequestException ex){
        ErrorResponse errorResponse = ErrorResponse
                                            .builder()
                                            .message(ex.getMessage())
                                            .localDateTime(LocalDateTime.now()).
                                            build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        ErrorResponse errorResponse = ErrorResponse
                                            .builder()
                                            .message("Internal Server Error")
                                            .localDateTime(LocalDateTime.now()).
                                            build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
