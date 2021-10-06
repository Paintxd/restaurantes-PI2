package br.edu.unoesc.pi2.restaurantes.dtos;

import java.util.List;

public class MenuDto {
    private Integer id;
    private String name;
    private String restaurant;
    private Double price;
    private Integer preparationTime;
    private List<InventoryMenuDto> ingredients;

    public MenuDto(Integer id, String name, String restaurant, Double price, Integer preparationTime, List<InventoryMenuDto> ingredients) {
        this.id = id;
        this.name = name;
        this.restaurant = restaurant;
        this.price = price;
        this.preparationTime = preparationTime;
        this.ingredients = ingredients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
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

    public List<InventoryMenuDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<InventoryMenuDto> ingredients) {
        this.ingredients = ingredients;
    }
}
