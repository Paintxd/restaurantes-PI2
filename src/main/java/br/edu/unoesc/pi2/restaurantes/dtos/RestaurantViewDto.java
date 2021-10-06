package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.Restaurant;

import javax.validation.constraints.NotBlank;

public class RestaurantViewDto {

    @NotBlank(message = "Informe um nome")
    private String name;

    @NotBlank(message = "Informe um endereço")
    private String address;

    @NotBlank(message = "Informe um segmento")
    private String type;

    public RestaurantViewDto(String name, String address, String type) {
        this.name = name;
        this.address = address;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Restaurant getRestaurant() {
        return new Restaurant(name, address, type);
    }
}
