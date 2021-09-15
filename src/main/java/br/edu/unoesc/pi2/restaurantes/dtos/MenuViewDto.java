package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.Menu;
import br.edu.unoesc.pi2.restaurantes.models.Restaurant;

public class MenuViewDto {

    private String name;

    private Double price;

    private Integer preparationTime;

    private Integer restaurantId;

    public MenuViewDto(String name, Double price, Integer preparationTime, Integer restaurantId) {
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Menu getMenu(Restaurant restaurant) {
        return new Menu(name, price, preparationTime, restaurant);
    }
}
