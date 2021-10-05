package br.edu.unoesc.pi2.restaurantes.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class InventoryViewDto {

    @NotNull(message = "Informe uma quantia para ter em estoque")
    @Min(value = 0, message = "Quantidade deve ser maior que zero")
    private BigDecimal quantity;

    public InventoryViewDto() {
    }

    public InventoryViewDto(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
