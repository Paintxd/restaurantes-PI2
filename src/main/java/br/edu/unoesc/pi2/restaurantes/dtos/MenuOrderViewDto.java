package br.edu.unoesc.pi2.restaurantes.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MenuOrderViewDto {

    @NotNull(message = "Informe o item do menu")
    private Integer menuId;

    @NotNull(message = "Informe a quantia pedida")
    @Min(value = 1, message = "Deve ser pedido ao menos um item do menu")
    private Integer quantity;

    public MenuOrderViewDto(Integer menuId, Integer quantity) {
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
