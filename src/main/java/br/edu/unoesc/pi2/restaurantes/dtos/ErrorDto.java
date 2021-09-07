package br.edu.unoesc.pi2.restaurantes.dtos;

public class ErrorDto {
    private final String field;
    private final String error;

    public ErrorDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
