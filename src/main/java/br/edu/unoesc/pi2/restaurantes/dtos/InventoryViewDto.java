package br.edu.unoesc.pi2.restaurantes.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryViewDto {
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal minQuantity;
    private LocalDateTime updateDateTime;
    private String itemName;

    public InventoryViewDto(Integer id, BigDecimal quantity, BigDecimal minQuantity, LocalDateTime updateDateTime, String itemName) {
        this.id = id;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.updateDateTime = updateDateTime;
        this.itemName = itemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(BigDecimal minQuantity) {
        this.minQuantity = minQuantity;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
