package br.edu.unoesc.pi2.restaurantes.controllers.handlers;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundHandler {

    record ErrorMessage(String message) {};

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage handle(NotFoundException exception) {
        return new ErrorMessage(exception.getMessage());
    }

}
