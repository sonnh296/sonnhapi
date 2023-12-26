package dev.sonnhapi.exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // triggers when the JSON is invalid
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> details = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));

        details.add(builder.toString());

        ErrorResponse err = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Invalid JSON", details);

        return new ResponseEntity<>(err, err.getStatus());
    }

    // triggers when the JSON is malformed
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ErrorResponse err = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Malformed JSON request", details);

        return new ResponseEntity<>(err, err.getStatus());
    }

    // triggers when there are missing parameters
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getParameterName() + " parameter is missing");

        ErrorResponse err = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Missing Parameters", details);

        return new ResponseEntity<>(err, err.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ErrorResponse err = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Mismatch Type", details);

        return new ResponseEntity<>(err, err.getStatus());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {

        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());

        ErrorResponse err = new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST, "Error occurred" ,details);

        return new ResponseEntity<>(err, err.getStatus());
    }
}
