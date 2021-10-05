package br.edu.unoesc.pi2.restaurantes.dtos;

import br.edu.unoesc.pi2.restaurantes.models.Menu;
import br.edu.unoesc.pi2.restaurantes.models.Restaurant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MenuViewDto {

    @NotBlank(message = "Informe um nome")
    private String name;

    @NotNull(message = "Informe um valor para o prato")
    private Double price;

    @NotNull(message = "Informe o tempo de preparo (em minutos)")
    private Integer preparationTime;

    @NotNull(message = "Informe o restaurante")
    private Integer restaurantId;

    @NotNull(message = "Informe itens que serão consumidos")
    @Size(min = 1, message = "Informe ao menos um item que sera consumido")
    private List<InventoryMenuViewDto> inventoryItems;

    public MenuViewDto(String name, Double price, Integer preparationTime, Integer restaurantId, List<InventoryMenuViewDto> inventoryItems) {
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
        this.restaurantId = restaurantId;
        this.inventoryItems = inventoryItems;
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

    public List<InventoryMenuViewDto> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryMenuViewDto> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public Menu getMenu(Restaurant restaurant) {
        return new Menu(name, price, preparationTime, restaurant);
    }
}
