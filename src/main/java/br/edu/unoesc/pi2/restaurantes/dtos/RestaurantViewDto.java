package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.Restaurant;

import javax.validation.constraints.NotBlank;

public class RestaurantViewDto {

    @NotBlank(message = "Informe um segmento")
    private String type;

    public RestaurantViewDto() {
    }

    public RestaurantViewDto(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Restaurant getRestaurant() {
        return new Restaurant(type);
    }
}
