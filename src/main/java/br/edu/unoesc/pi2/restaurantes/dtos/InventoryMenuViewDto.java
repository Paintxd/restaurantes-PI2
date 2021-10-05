package br.edu.unoesc.pi2.restaurantes.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class InventoryMenuViewDto {

    @NotNull(message = "Informe o item do estoque")
    private Integer inventoryId;

    @NotNull(message = "Informe uma quantia que será consumida")
    @Min(value = 0, message = "Quantidade deve ser maior que zero")
    private BigDecimal quantity;

    public InventoryMenuViewDto(Integer inventoryId, BigDecimal quantity) {
        this.inventoryId = inventoryId;
        this.quantity = quantity;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
