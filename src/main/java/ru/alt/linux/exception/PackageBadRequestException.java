package ru.alt.linux.exception;

public class PackageBadRequestException extends RuntimeException {
    public PackageBadRequestException(String message) {
        super(message);
    }
}
