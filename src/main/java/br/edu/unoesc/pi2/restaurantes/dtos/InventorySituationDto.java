package br.edu.unoesc.pi2.restaurantes.dtos;

import java.util.List;

public class InventorySituationDto {
    private List<InventoryViewDto> inInventory;
    private List<InventoryViewDto> lackingInventory;

    public InventorySituationDto() {
    }

    public List<InventoryViewDto> getInInventory() {
        return inInventory;
    }

    public void addInInventory(InventoryViewDto inventoryItem) {
        this.inInventory.add(inventoryItem);
    }

    public List<InventoryViewDto> getLackingInventory() {
        return lackingInventory;
    }

    public void addLackingInventory(InventoryViewDto inventoryItem) {
        this.lackingInventory.add(inventoryItem);
    }
}
