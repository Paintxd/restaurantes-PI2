package br.edu.unoesc.pi2.restaurantes.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MenuOrderViewDto {

    @NotNull(message = "Informe o item do menu")
    private int menuId;

    @NotNull(message = "Informe a quantia pedida")
    @Min(value = 1, message = "Deve ser pedido ao menos um item do menu")
    private int quantity;

    public MenuOrderViewDto(int menuId, int quantity) {
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
