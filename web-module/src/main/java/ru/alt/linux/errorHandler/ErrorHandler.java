package ru.alt.linux.errorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.alt.linux.exception.PackageBadRequestException;
import ru.alt.linux.exception.PackageNotFoundException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PackageBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError handleValidationException(PackageBadRequestException exp) {
        return new AppError("BAD REQUEST EXCEPTION" + exp.getMessage());
    }

    @ExceptionHandler(PackageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError handleNotFoundException(PackageNotFoundException exp) {
        return new AppError("NOT FOUND EXCEPTION " + exp.getMessage());
    }
}
