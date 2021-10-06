package br.edu.unoesc.pi2.restaurantes.dtos;

import java.math.BigDecimal;

public class InventoryMenuDto {
    private String ingredient;
    private String quantity;

    public InventoryMenuDto(String ingredient, String quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
