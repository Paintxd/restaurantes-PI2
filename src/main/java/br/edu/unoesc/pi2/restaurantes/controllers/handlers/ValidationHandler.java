package br.edu.unoesc.pi2.restaurantes.controllers.handlers;

import br.edu.unoesc.pi2.restaurantes.dtos.ErrorDto;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationHandler {

    private final MessageSource messageSource;

    public ValidationHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDto> handle(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> {
                    String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                    return new ErrorDto(fieldError.getField(), message);
                })
                .toList();
    }

}
