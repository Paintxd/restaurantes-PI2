package br.edu.unoesc.pi2.restaurantes.dtos;

import java.util.ArrayList;
import java.util.List;

public class InventorySituationDto {
    private final List<InventoryDto> inInventory = new ArrayList<>();
    private final List<InventoryDto> lackingInventory = new ArrayList<>();

    public List<InventoryDto> getInInventory() {
        return inInventory;
    }

    public void addInInventory(InventoryDto inventoryItem) {
        this.inInventory.add(inventoryItem);
    }

    public List<InventoryDto> getLackingInventory() {
        return lackingInventory;
    }

    public void addLackingInventory(InventoryDto inventoryItem) {
        this.lackingInventory.add(inventoryItem);
    }
}
