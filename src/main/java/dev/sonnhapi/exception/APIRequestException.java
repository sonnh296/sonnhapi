package dev.sonnhapi.exception;

public class APIRequestException extends RuntimeException{
    public APIRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
